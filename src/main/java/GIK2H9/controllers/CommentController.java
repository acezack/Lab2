package hogskolan.blog.controllers;

import hogskolan.blog.entity.Comment;
import hogskolan.blog.entity.Post;
import hogskolan.blog.entity.User;
import hogskolan.blog.repository.CommentRepository;
import hogskolan.blog.repository.PostRepository;
import hogskolan.blog.repository.UserRepository;
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
        return "postallbidsview";
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
            comment.setCommenttext(allFormRequestParams.get("comment"));
            comment.setUser(user);
            comment.setCreatedComment(date);
            Post post = postRepository.findById(p_id).get();
            post.addComment(comment);
            postRepository.save(post);

        return "redirect:/posts/page/0";
    }
}//end class
