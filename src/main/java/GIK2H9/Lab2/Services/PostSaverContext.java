package GIK2H9.Lab2.Services;

import GIK2H9.Lab2.Models.Post;
import GIK2H9.Lab2.Models.TestUser;
import GIK2H9.Lab2.Repositories.TestPostSaverStrategy;

import java.time.LocalDateTime;

public class PostSaverContext {
    private TestPostSaverStrategy testPostSaverStrategy;

    public PostSaverContext(TestPostSaverStrategy testPostSaverStrategy) {
        this.testPostSaverStrategy = testPostSaverStrategy;
    }

    public void setTestPostSaverStrategy(TestPostSaverStrategy testPostSaverStrategy) {
        this.testPostSaverStrategy = testPostSaverStrategy;
    }

    public void saveTestPost(TestUser testUser, String title, String body) {
        Post post = new Post(testUser, LocalDateTime.now(), title, body);
        this.testPostSaverStrategy.save(post);
    }
}
