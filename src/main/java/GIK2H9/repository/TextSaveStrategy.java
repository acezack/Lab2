package GIK2H9.repository;

import GIK2H9.entity.Comment;
import GIK2H9.services.CommentSaveStrategy;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TextSaveStrategy implements CommentSaveStrategy {

    @Override
    public void save (Comment comment) {

        BufferedWriter writer;
        try {
            writer = Files.newBufferedWriter(Paths.get("deletedComments.txt"), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            writer.write(comment.getText());
            writer.newLine();
            writer.close();
            System.out.println(comment.getText());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
