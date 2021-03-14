package GIK2H9.Lab2.Models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TestPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer p_id;

    private LocalDateTime dateTime;
    private String title;
    private String body;
    private Integer grading;

    @ManyToOne(fetch = FetchType.LAZY)
    private TestUser testUser;

    public TestPost() {
    }
}
