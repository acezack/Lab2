package GIK2H9.Lab2.Controllers;

import GIK2H9.Lab2.Models.User;
import GIK2H9.Lab2.Repositories.TestPostSaverStrategy;
import GIK2H9.Lab2.Repositories.TestUserSaverStrategy;
import GIK2H9.Lab2.Services.UserSaverContext;
import GIK2H9.Lab2.Services.UserSqlSaverStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SaveController {
    @Autowired
    UserSqlSaverStrategy userSqlSaverStrategy;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/posts/add")
    public void savePost() {

    }

    @PostMapping("/users/add")
    public String saveUser(@ModelAttribute User user) {
        System.out.println(user.toString());
        UserSaverContext userSaverContext = new UserSaverContext(userSqlSaverStrategy);
        userSaverContext.saveTestUser(user.getUsername(), encoder.encode(user.getPassword()), user.getRole(), 1);
        return "redirect:/users";
    }
}
