package GIK2H9.services;

import GIK2H9.entity.Comment;
import GIK2H9.entity.Post;
import GIK2H9.entity.User;
import GIK2H9.repository.CommentRepository;
import GIK2H9.repository.PostRepository;
import GIK2H9.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    public List<User> listAllUsers(String keyword){
        if(keyword != null){
            return userRepository.search(keyword);

        }
        return userRepository.findAll();
    }

    public List<Post> listAllPosts(String keyword) {
        if(keyword != null){
            return postRepository.search(keyword);
        }
        return postRepository.findAll();
    }

    public List<Comment> listAllComments(String keyword) {
        if(keyword != null){
            return commentRepository.search(keyword);
        }
        return commentRepository.findAll();
    }
}
