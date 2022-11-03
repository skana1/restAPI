package com.api.app.rest.Service;

import com.api.app.rest.Models.Post;
import com.api.app.rest.Repo.PostRepo;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    PostRepo postRepo;

    public PostService(PostRepo postRepo){
        this.postRepo = postRepo;
    }

    public Post save(Post post){
        return this.postRepo.save(post);
    }
}
