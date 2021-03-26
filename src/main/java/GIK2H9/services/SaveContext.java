package GIK2H9.services;
import GIK2H9.entity.Comment;


public class SaveContext {
    private CommentSaveStrategy commentSaveStrategy;
    public SaveContext(CommentSaveStrategy commentSaveStrategy){
        this.commentSaveStrategy = commentSaveStrategy;
    }

    public void save (Comment comment){
        commentSaveStrategy.save(comment);

    }
}//end class
