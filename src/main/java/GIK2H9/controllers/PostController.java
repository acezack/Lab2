package GIK2H9.controllers;

import GIK2H9.entity.Comment;
import GIK2H9.entity.Post;
import GIK2H9.entity.User;
import GIK2H9.repository.PostRepository;
import GIK2H9.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    //Show all posts med paging
   @GetMapping("/posts/page/{pageno}")
    public String showPage(@PathVariable() Integer pageno, Model model) {
       Boolean no = true;
        if (pageno < 0 || pageno == null) {
            pageno = 0;
        }
       User user = userRepository.findByEmail(new SecurityController().loggedInUser());
        final int PAGESIZE = 3; //number of posts on each page
        //get the next page based on its pagenumber, zerobased
        //also set pagesize, the number of posts on the page
        PageRequest paging = PageRequest.of(pageno, PAGESIZE);
        Page<Post> pagedResult = postRepository.findAll(paging);
        List<Post> listPosts;
        //returns the page content our 3 posts as List
        listPosts = pagedResult.getContent();
        model.addAttribute("currentPageNumber", pagedResult.getNumber()); //zerobased
        model.addAttribute("displayableCurrentPageNumber", pagedResult.getNumber() + 1);
        model.addAttribute("nextPageNumber", pageno + 1); //going forward to next page
        model.addAttribute("previousPageNumber", pageno - 1); //going backwards to previous page
        model.addAttribute("totalPages", pagedResult.getTotalPages());
        model.addAttribute("totalItems", pagedResult.getTotalElements());
        model.addAttribute("hasNext", pagedResult.hasNext());
        model.addAttribute("hasPrevious", pagedResult.hasPrevious());
        model.addAttribute("posts", listPosts);//set the list with the 3 posts
       if(user.getRole().equals("ROLE_BLOGGER")){
           no = false;
       }
       model.addAttribute("no", no);
        return "postallview";

    }


    //Show all posts med paging
    @GetMapping("/posts/user/page/{pageno}")
    public String showPageForUser(@PathVariable() Integer pageno, Model model) {
        Boolean no = true;
        if (pageno < 0 || pageno == null) {
            pageno = 0;
        }
        final int PAGESIZE = 3; //number of posts on each page
        //get the next page based on its pagenumber, zerobased
        //also set pagesize, the number of posts on the page

        User user = userRepository.findByEmail(new SecurityController().loggedInUser());


        Pageable all = PageRequest.of(pageno, PAGESIZE);
        List<Post> allPostsByUser = user.getPosts();

        PageRequest paging = PageRequest.of(pageno, PAGESIZE);
        Page<Post> pagedResult = postRepository.findAllByUser(user, paging);
        List<Post> listPost;
        //returns the page content our 3 posts as List
        listPost = pagedResult.getContent();
        model.addAttribute("currentPageNumber", pagedResult.getNumber()); //zerobased
        model.addAttribute("displayableCurrentPageNumber", pagedResult.getNumber() + 1);
        model.addAttribute("nextPageNumber", pageno + 1); //going forward to next page
        model.addAttribute("previousPageNumber", pageno - 1); //going backwards to previous page
        model.addAttribute("totalPages", pagedResult.getTotalPages());
        model.addAttribute("totalItems", pagedResult.getTotalElements());
        model.addAttribute("hasNext", pagedResult.hasNext());
        model.addAttribute("hasPrevious", pagedResult.hasPrevious());
        model.addAttribute("posts", listPost);//set the list with the 3 posts
        if(user.getRole().equals("ROLE_BLOGGER")){
            no = false;
        }
        model.addAttribute("no", no);

        return "postallview";

    }

    @Autowired
    SecurityController sec = new SecurityController();

    @RequestMapping("/posts/add")
    public String addPost() {
        return "postaddview";
    }
    @PostMapping("/posts/add")
    public String addPostToDB(@RequestParam Map<String, String> allFormRequestParams) {
        Post post = new Post();
        post.setTitle(allFormRequestParams.get("title"));
        post.setText(allFormRequestParams.get("text"));
        post.setDateTime(LocalDateTime.now());
        post.setGrading((double) 1);
        User user = userRepository.findByEmail(sec.loggedInUser());
        user.addPost(post);
        userRepository.save(user);
        if (user.getRole().equals("ROLE_BLOGGER")) {
            return "redirect:/blogger";
        } else {
            return "redirect:/posts/page/0";
        }
    }

    //delete post
    @GetMapping("/posts/delete/{p_id}")
    public String deletePostById(@PathVariable Integer p_id) {
        postRepository.deleteById(p_id);
        return "redirect:/blogger";
    }

    //update post
    @GetMapping("/posts/update/{p_id}")
    public String updatePostById(Model model, @PathVariable Integer p_id) {
        model.addAttribute("post",postRepository.findById(p_id).get());
        return "postupdateview";
    }

    @PostMapping("/posts/update/{p_id}")
    public String updatePost(@RequestParam Map<String, String> allFormRequestParams, Integer p_id) {
        Post post = postRepository.findById(p_id).get();
        post.setTitle(allFormRequestParams.get("name"));
        post.setText(allFormRequestParams.get("text"));
        postRepository.save(post);
        return "redirect:/blogger";
    }

    @PostMapping("/posts/grading/{p_id}")
    public String addGrading(@PathVariable Integer p_id, @RequestParam Map<String, String> allFormRequestParams) {
        User user = userRepository.findByEmail(new SecurityController().loggedInUser());
        Post post = postRepository.findById(p_id).get();
        Double grading = post.getGrading();
        Double gradeToAdd = Double.parseDouble(allFormRequestParams.get("grading"+p_id));
        Double newGrade = (grading+gradeToAdd)/(grading+5);
        post.setGrading(newGrade);
        postRepository.save(post);

        return "redirect:/posts/page/0";
    }
}//end Controller class
