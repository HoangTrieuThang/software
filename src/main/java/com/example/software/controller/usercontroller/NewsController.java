package com.example.software.controller.usercontroller;

import com.example.software.model.News;
import com.example.software.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/news", produces = "application/json")
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;

    @GetMapping("/list")
    public Iterable<News> getListNews(){
        return newsRepository.findAll();
    }


}
