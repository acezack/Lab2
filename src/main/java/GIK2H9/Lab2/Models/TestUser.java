package GIK2H9.Lab2.Models;

public class TestUser {
    private String username;
    private String password;
    private String role;
    private Integer enabled;

    public TestUser(String username, String password, String role, Integer enabled) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
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