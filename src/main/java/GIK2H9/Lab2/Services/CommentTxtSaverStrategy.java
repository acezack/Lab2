package GIK2H9.Lab2.Services;


import GIK2H9.Lab2.Models.TestComment;
import GIK2H9.Lab2.Repositories.TestCommentSaverStrategy;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Service
public class CommentTxtSaverStrategy implements TestCommentSaverStrategy {
    public void save(TestComment testComment) {
        BufferedWriter writer;
        try {
            writer = Files.newBufferedWriter(Paths.get("deletedComments.txt"), StandardCharsets.UTF_8, StandardOpenOption.APPEND);

            writer.write(testComment.getC_id()+";"+ testComment.getTestPost().getP_id()+";"+ testComment.getDateTime()+";"+ testComment.getBody()+";"+ testComment.getGrading()+";");
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}