package com.user.service;

import com.user.model.User;
import com.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;
    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }


    public Optional<User> findUser(int id) {
        Optional<User> user = userRepository.findById(id);
            User userData = user.get();
            String blogServiceUrl = "http://BLOG/blog/user/" + id;
            List forObject= restTemplate.getForObject(blogServiceUrl , List.class);
            userData.setBlogs(forObject);

        return user;
    }

    public User saveUser(User user) {
      return   userRepository.save((user));
    }

}
