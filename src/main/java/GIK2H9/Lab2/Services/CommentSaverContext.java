package GIK2H9.Lab2.Services;

import GIK2H9.Lab2.Models.*;
import GIK2H9.Lab2.Repositories.TestCommentSaverStrategy;
import GIK2H9.Lab2.Repositories.TestPostSaverStrategy;

import java.time.LocalDateTime;

public class CommentSaverContext {
    private TestCommentSaverStrategy testCommentSaverStrategy;

    public CommentSaverContext(TestCommentSaverStrategy testCommentSaverStrategy) {
        this.testCommentSaverStrategy = testCommentSaverStrategy;
    }

    public void setTestCommentSaverStrategy(TestCommentSaverStrategy testCommentSaverStrategy) {
        this.testCommentSaverStrategy = testCommentSaverStrategy;
    }

    public void saveTestComment(TestPost post, TestUser user, String body) {
        Comment comment = new Comment(post, user, LocalDateTime.now(), body);
    }
}
