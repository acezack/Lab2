package GIK2H9.Lab2.Services;

import GIK2H9.Lab2.Models.Comment;
import GIK2H9.Lab2.Models.TestComment;
import GIK2H9.Lab2.Models.TestUser;
import GIK2H9.Lab2.Models.User;
import GIK2H9.Lab2.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentSqlSaverStrategy implements CommentSaverStrategy {
    @Autowired
    private TestCommentRepository testCommentRepository;

    @Override
    public void save(Comment comment) {
        TestComment testComment = new TestComment(
                comment.getTestPost(),
                comment.getTestUser(),
                comment.getDateTime(),
                comment.getBody(),
                comment.getGrading());
        testCommentRepository.save(testComment);
    }
}
