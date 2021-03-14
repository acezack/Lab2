package GIK2H9.Lab2.Models;
import java.time.LocalDateTime;

public class Comment {
    private TestPost testPost;

    private TestUser testUser;

    private LocalDateTime dateTime;

    private String body;

    private Integer grading;

    public Comment(TestPost testPost, TestUser testUser, LocalDateTime dateTime, String body) {
        this.testPost = testPost;
        this.testUser = testUser;
        this.dateTime = dateTime;
        this.body = body;
    }

    public TestPost getTestPost() {
        return testPost;
    }

    public void setTestPost(TestPost testPost) {
        this.testPost = testPost;
    }

    public TestUser getTestUser() {
        return testUser;
    }

    public void setTestUser(TestUser testUser) {
        this.testUser = testUser;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getGrading() {
        return grading;
    }

    public void setGrading(Integer grading) {
        this.grading = grading;
    }
}
