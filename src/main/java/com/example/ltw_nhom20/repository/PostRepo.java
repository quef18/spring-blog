package com.example.ltw_nhom20.repository;

import com.example.ltw_nhom20.entity.Post;
import com.example.ltw_nhom20.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepo extends JpaRepository<Post, Integer> {
    Page<Post> findAllByUser(User user, Pageable pageable);

    Page<Post> findAll(Pageable pageable);

    Optional<Post> findById(Integer id);
}
