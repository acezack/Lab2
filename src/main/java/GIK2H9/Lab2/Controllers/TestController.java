package GIK2H9.Lab2.Controllers;

import GIK2H9.Lab2.Models.User;
import GIK2H9.Lab2.Services.UserSaverContext;
import GIK2H9.Lab2.Services.UserSqlSaverStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TestController {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    UserSqlSaverStrategy userSqlSaverStrategy;

    @GetMapping("/initdb")
    public String init() {
        UserSaverContext userSaverContext = new UserSaverContext(userSqlSaverStrategy);
        User testUser = new User("acezack",encoder.encode("asd"),"ROLE_ADMIN", 1);
        userSaverContext.saveTestUser(
                testUser.getUsername(),
                testUser.getPassword(),
                testUser.getRole(),
                testUser.getEnabled());

        System.out.println("Init complete");
        return "redirect:/";
    }

    @GetMapping("/")
    public String showIndex(Model model) {
        /*UserSaverContext saverContext = new UserSaverContext(sqlSaverStrategy);
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

    @GetMapping("/admin/add")
    public String showAdd(Model model) {
        return "addpostview";
    }

    @GetMapping("/deletepost/{p_id}")
    public String deletePostById(@PathVariable Integer p_id) {
        //testPostRepository
        return "";
    }

}
