package com.example.ltw_nhom20.service.bean;

import com.example.ltw_nhom20.service.PostService;

import com.example.ltw_nhom20.entity.Post;
import com.example.ltw_nhom20.repository.PostRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class PostServiceBean implements PostService {

    private final PostRepo postRepo;

    @Override
    public Optional<Post> findById(Integer id) {
        return postRepo.findById(id);
    }

    @Override
    public Post save(Post post) {
        return postRepo.saveAndFlush(post);
    }

    @Override
    public void delete(Post post) {
        postRepo.delete(post);
    }

}
