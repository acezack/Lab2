package GIK2H9.repository;

import GIK2H9.entity.Comment;
import GIK2H9.entity.Post;
import GIK2H9.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
   List<Comment> findAllByUser(User user);
   List<Comment> findAllByPost(Post post);
}
