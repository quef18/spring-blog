package com.example.ltw_nhom20.controller;

import com.example.ltw_nhom20.entity.Comment;
import com.example.ltw_nhom20.entity.Post;
import com.example.ltw_nhom20.entity.User;
import com.example.ltw_nhom20.service.CommentService;
import com.example.ltw_nhom20.service.PostService;
import com.example.ltw_nhom20.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class CommentController {
    private final PostService postService;
    private final UserService userService;
    private final CommentService commentService;

    @PostMapping("/createComment")
    public String createNewPost(@ModelAttribute("comment") Comment comment) {
        commentService.save(comment);
        return "redirect:/post/" + comment.getPost().getId();
    }

    @GetMapping("/commentPost/{id}")
    public String commentPostWithId(@PathVariable Integer id,
                                    Principal principal,
                                    Model model) {

        Optional<Post> post = postService.findById(id);

        if (post.isPresent()) {
            Optional<User> user = userService.findByUsername(principal.getName());

            if (user.isPresent()) {
                Comment comment = new Comment();
                comment.setUser(user.get());
                comment.setPost(post.get());
                model.addAttribute("comment", comment);
                return "/commentForm";

            } else {
                return "/error";
            }

        } else {
            return "/error";
        }
    }
}

