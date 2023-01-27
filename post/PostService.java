package com.vsd.SocialMediaApp.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    public boolean addPost(Post post){
        try{
            postRepository.save(post);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    public Iterable<Post> getAllPosts(Integer id){
        try{
            Iterable<Post> posts = postRepository.findAllByUser_Id(id);
            posts.forEach(post -> {
                post.setComments(commentRepository.findAllByPost_Id(post.getId()));
            });
            return posts;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Post> getAllPostByUser(Integer userId){
        List<Post> res = new ArrayList<>(postRepository.findAllByUser_Id(userId));
        res.forEach(post -> {
            post.setComments(commentRepository.findAllByPost_Id(post.getId()));
        });

        return res;
    }

    public boolean addCommentOnPost(Comment comment){
        commentRepository.save(comment);
        return true;
    }
}
