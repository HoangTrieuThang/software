package com.example.software.controller.usercontroller;

import com.example.software.model.NewsKind;
import com.example.software.repository.NewsKindRepository;
import com.example.software.services.NewsKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news-kind")
@CrossOrigin(origins = {"*"})
public class NewsKindController {

    @Autowired
    private NewsKindRepository newsKindRepository;

    @Autowired
    private NewsKindService newsKindService;

    @GetMapping("/list")
    public List<NewsKind> getListNewsKind() {
        return newsKindRepository.findAll();
    }

    // find by id
    @GetMapping("{id}")
    public NewsKind getNewsByNewsKindId(@PathVariable("id") Integer id){
        NewsKind NewsKind = newsKindService.findNewsByNewKindId(id);
        return  NewsKind;
    }

//    @GetMapping("{id}")
//    public List<NewsKind> getNewsKindByIdAndName(@PathVariable int news_kind, String news_kind_name){
//        List<NewsKind> newsKindList = newsKindRepository.findNewsKindByNews_kindAndNews_kind_name(news_kind,news_kind_name);
//        return newsKindList;
//    }
//
//
////cua admin
//    @PostMapping("/save")
//    public String saveNewsKind(@RequestBody NewsKind newsKind){
//        newsKindRepository.save(newsKind);
//        return "save success...";
//    }

}
