package GIK2H9.Lab2.Repositories;

import GIK2H9.Lab2.Models.TestComment;
import GIK2H9.Lab2.Models.TestPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCommentRepository extends CrudRepository<TestComment, Integer> {
}
