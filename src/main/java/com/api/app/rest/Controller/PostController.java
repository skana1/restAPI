package com.api.app.rest.Controller;

import com.api.app.rest.Models.Post;
import com.api.app.rest.Repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostRepo postRepo;

    @GetMapping(value = "/post")
    public List<Post> getPost(){
        return postRepo.findAll();
    }

    @PostMapping(value = "/savePost")
    public String savePost(@RequestBody Post post){
        postRepo.save(post);
        return "Saved";
    }
    @PutMapping(value = "/updatePost/{id}")
    public String updatePost(@PathVariable long id, @RequestBody Post post){
        Post updatedPost = postRepo.findById(id).get();
        updatedPost.setUser_id(post.getUser_id());
        updatedPost.setDescription(post.getDescription());
        postRepo.save(updatedPost);
        return "updated";
    }

    @DeleteMapping (value = "/deletePost/{id}")
    public String deletePost (@ PathVariable long id){
        Post deletePost = postRepo.findById(id).get();
        postRepo.delete(deletePost);
        return "Delete post with id" + id;
    }
}
