package GIK2H9.repository;

import GIK2H9.entity.Post;
import GIK2H9.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
    Page<Post> findAllByUser(User user, Pageable pageable);
}