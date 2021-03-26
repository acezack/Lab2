package GIK2H9.repository;

import GIK2H9.entity.Comment;
import GIK2H9.entity.Post;
import GIK2H9.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
   @Query("SELECT c FROM Comment c WHERE c.text LIKE %?1%")
public List<Comment> search(String keyword);
   List<Comment> findAllByUser(User user);
   Comment findByUserAndPost(User user, Post post);
   List<Comment> findAllByPostOrderByDateTimeDesc(Post post);
}
