package GIK2H9.Lab2.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TestUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer u_id;

    @OneToMany(
            mappedBy = "testUser",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TestPost> posts = new ArrayList<>();

    private String username;
    private String password;
    private String role;
    private Integer enabled;
}
