package com.guru.jpa.controller;

import com.guru.jpa.repository.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    @Autowired
    private AuthorsRepository authorsRepository;


    @RequestMapping("/authors")
    public String getAllAuthors(Model model) {
        model.addAttribute("authors", authorsRepository.findAll());
        return "authors";
    }
}
