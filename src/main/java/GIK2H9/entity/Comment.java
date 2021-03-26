package GIK2H9.entity;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Comment{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer b_id;
    private String text;
    private LocalDate date;
    private Double grading;


    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Comment() {

    }

    public Comment(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getB_id() {
        return b_id;
    }

    public void setB_id(Integer b_id) {
        this.b_id = b_id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getText() {
        return text;
    }

    public void setText(String commenttext) {
        this.text = commenttext;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate createdComment) {
        this.date = createdComment;
    }

    public Double getGrading() {
        return grading;
    }

    public void setGrading(Double grading) {
        this.grading = grading;
    }
}
