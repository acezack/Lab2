package GIK2H9.Lab2.Models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TestPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer p_id;

    @ManyToOne(fetch = FetchType.LAZY)
    private TestUser testUser;

    @OneToMany(
            mappedBy = "testPost",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TestComment> comments = new ArrayList<>();

    private LocalDateTime dateTime;
    private String title;
    private String body;
    private Integer grading;

    public TestPost() {
    }

    public TestPost(TestUser testUser, LocalDateTime dateTime, String title, String body) {
        this.testUser = testUser;
        this.dateTime = dateTime;
        this.title = title;
        this.body = body;
    }

    public Integer getP_id() {
        return p_id;
    }

    public TestUser getTestUser() {
        return testUser;
    }

    public List<TestComment> getComments() {
        return comments;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Integer getGrading() {
        return grading;
    }
}
