package com.example.software.controller.usercontroller;

import com.example.software.model.News;
import com.example.software.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Text;

import java.util.Optional;

@RestController
@RequestMapping(path = "/news", produces = "application/json")
public class NewsController {

//    @Autowired
//    private NewsRepository newsRepository;

//    @GetMapping("api/list")
//    public Iterable<News> getListNews(){
//        return newsRepository.findAll();
//    }
//
//    @GetMapping("api/list/{name}")
//    public Optional<News> getListOfLatestArticles(@PathVariable(value = "id") Integer id){
//        Optional<News> newsSearch = newsRepository.findById(id);
//        return newsSearch;
//
//    }

//    @GetMapping("api/search/{content}")
//    public Iterable<News> getNewsByContent(@PathVariable(value = "content") Text content){
//        Iterable<News> newsSearch = newsRepository.findNewsByContent(content);
//        return  newsSearch;
//    }

}
