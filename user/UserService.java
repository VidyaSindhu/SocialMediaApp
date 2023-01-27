package com.vsd.SocialMediaApp.user;

import com.vsd.SocialMediaApp.post.PostRepository;
import com.vsd.SocialMediaApp.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    public Iterable<User> getUsers(){
        Iterable<User> res = userRepository.findAll();
        res.forEach(user -> {
            user.setPosts(postService.getAllPostByUser(user.getId()));
        });

        return res;
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public Iterable<User> getUser(String email){
        return userRepository.findUserByEmailEquals(email);
    }
}
