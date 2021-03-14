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

    @OneToMany(
            mappedBy = "testUser",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TestComment> comments = new ArrayList<>();

    private String username;
    private String password;
    private String role;
    private Integer enabled;

    public TestUser() {
    }

    public TestUser(String username, String password, String role, Integer enabled) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
    }

    public Integer getU_id() {
        return u_id;
    }

    public List<TestPost> getPosts() {
        return posts;
    }

    public List<TestComment> getComments() {
        return comments;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public Integer getEnabled() {
        return enabled;
    }
}
