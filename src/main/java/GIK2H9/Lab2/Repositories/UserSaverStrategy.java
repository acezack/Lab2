package GIK2H9.Lab2.Repositories;

import GIK2H9.Lab2.Models.TestUser;
import GIK2H9.Lab2.Models.User;

public interface UserSaverStrategy {
    public void save(TestUser testUser);
}
