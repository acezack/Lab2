package GIK2H9.controllers;

import GIK2H9.entity.Comment;
import GIK2H9.entity.Post;
import GIK2H9.entity.User;
import GIK2H9.repository.CommentRepository;
import GIK2H9.repository.PostRepository;
import GIK2H9.repository.TextSaveStrategy;
import GIK2H9.repository.UserRepository;
import GIK2H9.services.CommentSaveStrategy;
import GIK2H9.services.SaveContext;
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

    @RequestMapping("/comment/user")
    public String showLoggedInUsersComments(Model model) {
        model.addAttribute("comments", commentRepository.findAllByUser(userRepository.findByEmail(sec.loggedInUser())));
        return "commentallbyuserview";
    }

    @RequestMapping("/comment/user/{u_id}")
    public String showUsersComments(Model model, @PathVariable Integer u_id) {
        model.addAttribute("comments", commentRepository.findAllByUser(userRepository.findById(u_id).get()));
        return "commentallbyuserview";
    }
    //show all comments
    @GetMapping("/posts/comment/{p_id}")
    public String getAllComments(Model model, @PathVariable Integer p_id) {
        Post post = postRepository.findById(p_id).get();
        List<Comment> comments = commentRepository.findAllByPostOrderByDateTimeDesc(post);
        model.addAttribute("comments", comments);
        return "postallcommentsview";
    }
    @Autowired
    SecurityController sec = new SecurityController();

    //add comment
    @RequestMapping("/comment/add/{p_id}")
    public String addComment(Model model, @PathVariable Integer p_id) {
        Post post = postRepository.findById(p_id).get();
        User user = userRepository.findByEmail(sec.loggedInUser());
        Comment comment = commentRepository.findByUserAndPost(user, post);
        System.out.println(comment);
        model.addAttribute("post", post);
        if (comment == null) {
            model.addAttribute("exists", false);
        }
        else {
            model.addAttribute("exists", true);
        }
        return "commentaddview";
    }

    @PostMapping("/comment/add/{p_id}")
    public String addComment(@PathVariable Integer p_id, @RequestParam Map<String, String> allFormRequestParams) {
            User user = userRepository.findByEmail(new SecurityController().loggedInUser());
            Comment comment = new Comment();
            comment.setText(allFormRequestParams.get("comment"));
            comment.setUser(user);
            comment.setDateTime(LocalDateTime.now());
            Post post = postRepository.findById(p_id).get();
            post.addComment(comment);
            postRepository.save(post);

        return "redirect:/posts/page/0";
    }

    @GetMapping("/comment/update/{c_id}")
    public String updateCommentView(Model model, @PathVariable Integer c_id) {
        model.addAttribute("comment", commentRepository.findById(c_id).get());
        return "commentupdateview";
    }

    @PostMapping("/comment/update/{c_id}")
    public String updateComment(@RequestParam Map<String, String> params, @PathVariable Integer c_id) {
        Comment comment = commentRepository.findById(c_id).get();
        comment.setText(params.get("text"));
        commentRepository.save(comment);
        return "redirect:/comment/user";
    }

    //delete comment
    @GetMapping("/blogger/comment/delete/{c_id}")
    public String deleteCommentById(@PathVariable Integer c_id) {
        Comment comment = commentRepository.findById(c_id).get();
        CommentSaveStrategy commentSaveStrategy = new TextSaveStrategy();
        SaveContext context = new SaveContext(commentSaveStrategy);
        context.save(comment);
        commentRepository.deleteById(c_id);
        return "redirect:/comment/user";
    }
}//end class
