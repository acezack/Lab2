package GIK2H9.Lab2.Services;

import GIK2H9.Lab2.Models.User;
import GIK2H9.Lab2.Repositories.TestUserSaverStrategy;

public class SaverContext {
    private TestUserSaverStrategy testUserSaverStrategy;

    public SaverContext(TestUserSaverStrategy testUserSaverStrategy) {
        this.testUserSaverStrategy = testUserSaverStrategy;
    }

    public void setUserSaverStrategy(TestUserSaverStrategy testUserSaverStrategy) {
        this.testUserSaverStrategy = testUserSaverStrategy;
    }

    public void saveTestUser(String username, String password, String role, Integer enabled) {
        User user = new User(username,password,role,enabled);
        this.testUserSaverStrategy.save(user);
    }
}
