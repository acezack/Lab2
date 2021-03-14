package GIK2H9.Lab2.Repositories;

import GIK2H9.Lab2.Models.Comment;
import GIK2H9.Lab2.Models.TestComment;

public interface CommentSaverStrategy {
    public void save(Comment comment);
}
