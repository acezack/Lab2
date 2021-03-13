package GIK2H9.Lab2.Controllers;

import GIK2H9.Lab2.Models.Roles;
import GIK2H9.Lab2.Models.TestUser;
import GIK2H9.Lab2.Models.User;
import GIK2H9.Lab2.Repositories.UserRepository;
import GIK2H9.Lab2.Security.SqlSaverStrategy;
import GIK2H9.Lab2.Services.SaverContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    SqlSaverStrategy sqlSaverStrategy;

    @GetMapping("/")
    public String showIndex(Model model) {
        /*SaverContext saverContext = new SaverContext(sqlSaverStrategy);
        TestUser testUser = new TestUser("acezack",encoder.encode("asd"),"ROLE_ADMIN", 1);
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
}
