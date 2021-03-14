package GIK2H9.Lab2.Controllers;

import GIK2H9.Lab2.Models.Role;
import GIK2H9.Lab2.Repositories.TestCommentRepository;
import GIK2H9.Lab2.Repositories.TestPostRepository;
import GIK2H9.Lab2.Repositories.TestUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GetController {

    private TestPostRepository testPostRepository;
    @Autowired
    public void setTestPostRepository(TestPostRepository testPostRepository) {
        this.testPostRepository = testPostRepository;
    }

    private TestCommentRepository testCommentRepository;
    @Autowired
    public void setTestCommentRepository(TestCommentRepository testCommentRepository) {
        this.testCommentRepository = testCommentRepository;
    }

    private TestUserRepository testUserRepository;
    @Autowired
    public GetController(TestUserRepository testUserRepository) {
        this.testUserRepository = testUserRepository;
    }

    @GetMapping("/posts")
    public String getPosts(Model model) {
        model.addAttribute("posts", testPostRepository.findAll());
        return "postsview";
    }

    @GetMapping("/posts/add")
    public String getPostsAdd() {
        return "addpostview";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", testUserRepository.findAll());
        return "usersview";
    }

    @GetMapping("/users/add")
    public String getUsersAdd(Model model) {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role("ROLE_USER", true));
        roles.add(new Role("ROLE_ADMIN", false));
        model.addAttribute("roles", roles);
        return "adduserview";
    }
}
