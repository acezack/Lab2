package GIK2H9.Lab2.Services;

import GIK2H9.Lab2.Models.Post;
import GIK2H9.Lab2.Models.TestPost;
import GIK2H9.Lab2.Models.TestUser;
import GIK2H9.Lab2.Models.User;
import GIK2H9.Lab2.Repositories.TestPostRepository;
import GIK2H9.Lab2.Repositories.TestPostSaverStrategy;
import GIK2H9.Lab2.Repositories.TestUserRepository;
import GIK2H9.Lab2.Repositories.TestUserSaverStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostSqlSaverStrategy implements TestPostSaverStrategy {
    @Autowired
    private TestPostRepository testPostRepository;

    @Override
    public void save(Post post) {
        TestPost testPost = new TestPost(
                post.getTestUser(),
                post.getDateTime(),
                post.getTitle(),
                post.getBody());
        testPostRepository.save(testPost);
    }
}
