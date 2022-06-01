package com.example.ltw_nhom20.controller;

import com.example.ltw_nhom20.entity.Post;
import com.example.ltw_nhom20.entity.User;
import com.example.ltw_nhom20.repository.PostRepo;
import com.example.ltw_nhom20.service.PostService;
import com.example.ltw_nhom20.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class BlogController {
    private final PostRepo postRepo;
    private final UserService userService;
    private final PostService postService;

    @GetMapping("/blog/{username}")
    public String blogForUsername(@PathVariable String username,
                                  @RequestParam("page") Optional<Integer> pageNo,
                                  Model model) {

        Optional<User> optionalUser = userService.findByUsername(username);
        Pageable page = PageRequest.of(pageNo.orElse(0), 2);

        User user = optionalUser.get();
        Page<Post> posts = postRepo.findAllByUser(user, page);


        model.addAttribute("posts", posts);
        model.addAttribute("user", user);

        return "/posts";
    }
}
