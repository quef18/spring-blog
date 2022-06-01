package com.example.ltw_nhom20.service;

import com.example.ltw_nhom20.entity.Post;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface PostService {
    Optional<Post> findById(Integer id);

    Post save(Post post);

    void delete(Post post);
}
