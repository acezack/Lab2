package GIK2H9.Lab2.Models;

import java.time.LocalDateTime;

public class Post {
    private TestUser testUser;
    private LocalDateTime dateTime;
    private String title;
    private String body;

    public Post(TestUser testUser, LocalDateTime dateTime, String title, String body) {
        this.testUser = testUser;
        this.dateTime = dateTime;
        this.title = title;
        this.body = body;
    }

    public TestUser getTestUser() {
        return testUser;
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
}
