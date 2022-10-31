package com.api.app.rest.Repo;

import com.api.app.rest.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {
}
