package GIK2H9.Lab2.Controllers;

import GIK2H9.Lab2.Repositories.TestPostRepository;
import GIK2H9.Lab2.Repositories.TestUserRepository;
import GIK2H9.Lab2.Services.SqlSaverStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TestController {
    @Autowired
    TestUserRepository testUserRepository;
    @Autowired
    TestPostRepository testPostRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    SqlSaverStrategy sqlSaverStrategy;

    @GetMapping("/")
    public String showIndex(Model model) {
        /*SaverContext saverContext = new SaverContext(sqlSaverStrategy);
        User testUser = new User("acezack",encoder.encode("asd"),"ROLE_ADMIN", 1);
        saverContext.saveTestUser(testUser.
                getUsername(),
                testUser.getPassword(),
                testUser.getRole(),
                testUser.getEnabled());
         */
        return "indexview";
    }

    @GetMapping("/admin")
    public String showAdmin(Model model) {
        return "adminview";
    }

    @GetMapping
    public String showAdd(Model model) {
        return "addview";
    }

    @GetMapping("/deletepost/{p_id}")
    public String deletePostById(@PathVariable Integer p_id) {
        //testPostRepository
        return "";
    }

}
