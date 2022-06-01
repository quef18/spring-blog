package com.example.ltw_nhom20.repository;

import com.example.ltw_nhom20.entity.Comment;
import com.example.ltw_nhom20.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
    @Transactional
    void deleteAllByPost(Post post);
}
