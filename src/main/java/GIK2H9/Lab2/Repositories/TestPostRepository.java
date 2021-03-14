package GIK2H9.Lab2.Repositories;

import GIK2H9.Lab2.Models.TestPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestPostRepository extends CrudRepository<TestPost, Integer> {
}
