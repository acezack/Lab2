package GIK2H9.controllers;


import GIK2H9.entity.Comment;
import GIK2H9.repository.CommentRepository;
import GIK2H9.repository.PostRepository;
import GIK2H9.repository.TextSaveStrategy;
import GIK2H9.repository.UserRepository;
import GIK2H9.services.CommentSaveStrategy;
import GIK2H9.services.SaveContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;


    //Visas i tabellen i bloggerview
    @RequestMapping("/blogger")
    public String showBlogger(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("comments", commentRepository.findAll());
        return "bloggerview";
    }

    @Autowired
    PasswordEncoder encoder;

    //delete comment
    @GetMapping("/blogger/comment/delete/{b_id}")
    public String deleteCommentById(@PathVariable Integer b_id) {
        Comment comment = commentRepository.findById(b_id).get();
        CommentSaveStrategy commentSaveStrategy = new TextSaveStrategy();
        SaveContext context = new SaveContext(commentSaveStrategy);
        context.save(comment);
        commentRepository.deleteById(b_id);
        return "redirect:/blogger";
    }


}