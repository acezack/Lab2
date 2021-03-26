package hogskolan.blog.controllers;


import hogskolan.blog.entity.Comment;
import hogskolan.blog.repository.CommentRepository;
import hogskolan.blog.repository.PostRepository;
import hogskolan.blog.repository.UserRepository;
import hogskolan.blog.services.CommentSaveStrategy;
import hogskolan.blog.services.SaveContext;
import hogskolan.blog.repository.TextSaveStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;


    //Visas i tabellen i adminview
    @RequestMapping("/admin")
    public String showAdmin(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("comments", commentRepository.findAll());
        return "bloggerview";
    }

    @Autowired
    PasswordEncoder encoder;

    //delete comment
    @GetMapping("/admin/comment/delete/{b_id}")
    public String deleteCommentById(@PathVariable Integer b_id) {
        Comment comment = commentRepository.findById(b_id).get();
        CommentSaveStrategy commentSaveStrategy = new TextSaveStrategy();
        SaveContext context = new SaveContext(commentSaveStrategy);
        context.save(comment);
        commentRepository.deleteById(b_id);
        return "redirect:/admin";
    }


}