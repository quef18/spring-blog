package com.example.ltw_nhom20.controller;

import com.example.ltw_nhom20.entity.Post;
import com.example.ltw_nhom20.repository.PostRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class HomeController {
    private final PostRepo postRepo;

    @GetMapping("/")
    public String home(Model model, @RequestParam("page") Optional<Integer> pageNo) {
        Pageable page = PageRequest.of(pageNo.orElse(0), 2);
        Page<Post> posts = postRepo.findAll(page);

        model.addAttribute("posts", posts);

        return "/home";
    }


}
