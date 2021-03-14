package GIK2H9.Lab2.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class TestComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer c_id;

    private Integer u_id;

    private Integer p_id;

    private LocalDateTime dateTime;

    private String body;

    private Integer grading;
}
