package GIK2H9.repository;

import GIK2H9.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.name LIKE %?1%")
    public List<User> search(String keyword);
    User findByEmail(String email);
}
