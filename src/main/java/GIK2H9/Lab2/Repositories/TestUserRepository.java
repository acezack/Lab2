package GIK2H9.Lab2.Repositories;

import GIK2H9.Lab2.Models.TestUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestUserRepository extends CrudRepository<TestUser, Integer> {
    TestUser findByUsername(String username);
}
