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

import java.time.LocalDateTime;
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
    @GetMapping("/posts/comments/{p_id}")
    public String getAllComments(Model model, @PathVariable Integer p_id) {
        Post post = postRepository.findById(p_id).get();
        List<Comment> comments = commentRepository.findAllByPost(post);
        model.addAttribute("comments", comments);
        return "postallcommentsview";
    }
    @Autowired
    SecurityController sec = new SecurityController();

    //add comment
    @RequestMapping("/comment/add/{p_id}")
    public String addComment(Model model, @PathVariable Integer p_id) {
        model.addAttribute("post", postRepository.findById(p_id).get());
        return "commentaddview";
    }

    @PostMapping("/comment/add/{p_id}")
    public String addComment(@PathVariable Integer p_id, @RequestParam Map<String, String> allFormRequestParams) {
            User user = userRepository.findByEmail(new SecurityController().loggedInUser());
            Comment comment = new Comment();
            comment.setText(allFormRequestParams.get("comment"));
            comment.setUser(user);
            comment.setDateTime(LocalDateTime.now());
            comment.setGrading((double) 0);
            Post post = postRepository.findById(p_id).get();
            post.addComment(comment);
            postRepository.save(post);

        return "redirect:/posts/page/0";
    }
}//end class
