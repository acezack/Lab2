package GIK2H9.Lab2.Security;

import GIK2H9.Lab2.Models.TestUser;
import GIK2H9.Lab2.Models.User;
import GIK2H9.Lab2.Repositories.UserRepository;
import GIK2H9.Lab2.Repositories.UserSaverStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SqlSaverStrategy implements UserSaverStrategy {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(TestUser testUser) {
        User user = new User(testUser.getUsername(),
                testUser.getPassword(),
                testUser.getRole(),
                testUser.getEnabled());
        userRepository.save(user);
    }
}
