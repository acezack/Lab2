package GIK2H9.repository;

import GIK2H9.entity.Post;
import GIK2H9.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query("SELECT p FROM Post p WHERE p.title LIKE %?1%"
    + "OR p.text LIKE %?1%")
    public List<Post> search(String keyword);
    Page<Post> findAllByUser(User user, Pageable pageable);
}
