package GIK2H9.controllers;

import GIK2H9.entity.Comment;
import GIK2H9.entity.Post;
import GIK2H9.entity.User;
import GIK2H9.repository.CommentRepository;
import GIK2H9.repository.PostRepository;
import GIK2H9.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
public class CommentController {

@Autowired
UserRepository userRepository;
@Autowired
PostRepository postRepository;
@Autowired
CommentRepository commentRepository;

    //show all comments
    @GetMapping("/posts/allcomments/{p_id}")
    public String getAllBids(Model model, @PathVariable Integer p_id) {
        Post post = postRepository.findById(p_id).get();
        List<Comment> comments = commentRepository.findAllByPost(post);
        model.addAttribute("comments", comments);
        return "postallcommentsview";
    }
    @Autowired
    SecurityController sec = new SecurityController();

    //add comment
    @RequestMapping("/addcomment/{p_id}")
    public String addBid(Model model, @PathVariable Integer p_id) {
        model.addAttribute("post", postRepository.findById(p_id).get());
        return "commentview";
    }

    @PostMapping("/addcomment/{p_id}")
    public String addBid(@PathVariable Integer p_id, @RequestParam Map<String, String> allFormRequestParams) {
            User user = userRepository.findByEmail(new SecurityController().loggedInUser());
            LocalDate date = LocalDate.now();
            Comment comment = new Comment();
            comment.setText(allFormRequestParams.get("comment"));
            comment.setUser(user);
            comment.setDate(date);
            comment.setGrading((double) 0);
            Post post = postRepository.findById(p_id).get();
            post.addComment(comment);
            postRepository.save(post);

        return "redirect:/posts/page/0";
    }
}//end class
