package GIK2H9.services;

import GIK2H9.entity.User;
import GIK2H9.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SearchService {
    @Autowired
    private UserRepository repo;

    public List<User> listAll(String keyword){
        if(keyword !=null){
            return repo.search(keyword);

        }
        return repo.findAll();
    }
}
