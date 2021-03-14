package GIK2H9.Lab2.Models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TestComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer c_id;

    @ManyToOne(fetch = FetchType.LAZY)
    private TestPost testPost;

    @ManyToOne(fetch = FetchType.LAZY)
    private TestUser testUser;

    private LocalDateTime dateTime;

    private String body;

    private Integer grading;

    public TestComment() {
    }

    public TestComment(TestPost testPost, TestUser testUser, LocalDateTime dateTime, String body, Integer grading) {
        this.testPost = testPost;
        this.testUser = testUser;
        this.dateTime = dateTime;
        this.body = body;
        this.grading = grading;
    }

    public Integer getC_id() {
        return c_id;
    }

    public TestPost getTestPost() {
        return testPost;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getBody() {
        return body;
    }

    public Integer getGrading() {
        return grading;
    }
}
