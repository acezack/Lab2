package GIK2H9.Lab2.Services;

import GIK2H9.Lab2.Models.TestUser;
import GIK2H9.Lab2.Repositories.UserSaverStrategy;

public class SaverContext {
    private UserSaverStrategy userSaverStrategy;

    public SaverContext(UserSaverStrategy userSaverStrategy) {
        this.userSaverStrategy = userSaverStrategy;
    }

    public void setUserSaverStrategy(UserSaverStrategy userSaverStrategy) {
        this.userSaverStrategy = userSaverStrategy;
    }

    public void saveTestUser(String username, String password, String role, Integer enabled) {
        TestUser testUser = new TestUser(username,password,role,enabled);
        this.userSaverStrategy.save(testUser);
    }
}
