package GIK2H9.Lab2.Models;

public class User {
    private String username;
    private String password;
    private String role;
    private Integer enabled;

    public User(String username, String password, String role, Integer enabled) {
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

    @Override
    public String toString() {
        return getUsername() + ";" + getRole() + ";" + getEnabled();
    }
}