package com.example.ltw_nhom20.controller;

import com.example.ltw_nhom20.entity.Post;
import com.example.ltw_nhom20.entity.User;
import com.example.ltw_nhom20.repository.CommentRepo;
import com.example.ltw_nhom20.service.PostService;
import com.example.ltw_nhom20.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class PostController {
    private final PostService postService;
    private final UserService userService;
    private final CommentRepo commentRepo;

    @GetMapping("/newPost")
    public String newPost(Principal principal,
                          Model model) {

        Optional<User> user = userService.findByUsername(principal.getName());

        Post post = new Post();
        post.setUser(user.get());

        model.addAttribute("post", post);

        return "/postForm";
    }

    @PostMapping("/newPost")
    public String createNewPost(@ModelAttribute("post") Post post) {
        postService.save(post);
        return "redirect:/blog/" + post.getUser().getUsername();
    }

    @GetMapping("/editPost/{id}")
    public String editPostWithId(@PathVariable Integer id,
                                 Principal principal,
                                 Model model) {

        Optional<Post> optionalPost = postService.findById(id);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();

            if (isPrincipalOwnerOfPost(principal, post)) {
                model.addAttribute("post", post);
                return "/postForm";
            }
        }
        return "redirect:/home";
    }

    @GetMapping("/post/{id}")
    public String getPostWithId(@PathVariable Integer id,
                                Principal principal,
                                Model model) {

        Optional<Post> optionalPost = postService.findById(id);

        Post post = optionalPost.get();

        model.addAttribute("post", post);
        if (isPrincipalOwnerOfPost(principal, post)) {
            model.addAttribute("username", principal.getName());
        }

        return "/post";
    }

    @PostMapping("/post/{id}")
    public String deletePostWithId(@PathVariable Integer id,
                                   Principal principal) {

        Optional<Post> optionalPost = postService.findById(id);
        Post post = optionalPost.get();

        if (isPrincipalOwnerOfPost(principal, post)) {
            commentRepo.deleteAllByPost(post);
            postService.delete(post);

        }
        return "redirect:/home";

    }

    private boolean isPrincipalOwnerOfPost(Principal principal, Post post) {
        return principal != null && principal.getName().equals(post.getUser().getUsername());
    }
}
