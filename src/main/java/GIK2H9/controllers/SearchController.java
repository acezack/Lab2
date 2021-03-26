package GIK2H9.controllers;

import GIK2H9.entity.Post;
import GIK2H9.entity.User;
import GIK2H9.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private SearchService searchService;

    @GetMapping("/search/")
    public String showIndex(Model model, @Param("keyword") String keyword) {
        List<User> users = searchService.listAllUsers(keyword);
        List<Post> posts = searchService.listAllPosts(keyword);

        model.addAttribute("users", users);
        model.addAttribute("posts", posts);

        model.addAttribute("keyword", keyword);
        return "searchresultview";
    }
}
