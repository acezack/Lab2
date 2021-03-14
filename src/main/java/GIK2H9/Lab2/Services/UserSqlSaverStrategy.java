package GIK2H9.Lab2.Services;

import GIK2H9.Lab2.Models.TestUser;
import GIK2H9.Lab2.Models.User;
import GIK2H9.Lab2.Repositories.TestUserRepository;
import GIK2H9.Lab2.Repositories.TestUserSaverStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSqlSaverStrategy implements TestUserSaverStrategy {
    @Autowired
    private TestUserRepository testUserRepository;

    @Override
    public void save(User user) {
        TestUser testUser = new TestUser(user.getUsername(),
                user.getPassword(),
                user.getRole(),
                user.getEnabled());
        testUserRepository.save(testUser);
    }
}
