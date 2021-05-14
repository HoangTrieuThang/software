package com.example.software.controller.usercontroller;

import com.example.software.common.ApiResponse;
import com.example.software.model.News;
import com.example.software.repository.NewsRepository;
import com.example.software.services.NewsService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user/news")
@CrossOrigin(origins = {"*"})
public class NewsController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private NewsRepository newsRepository;

    @GetMapping(value = "/getAlls",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<News>> getAllNews() {
        System.out.println("Aaaaaa");
        List<News> newsList = newsService.getAllNews();
        return new ResponseEntity<>(newsList,HttpStatus.OK);
    }

// 2 cai tim theo bai viet moi nhat va nhieu luot xem nhat bi loi 400
//list bai viet moi nhat
        @GetMapping(value="/date" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<News>> getNewsByDate(){
        return new ResponseEntity<>(newsRepository.findTopNewsDate(), HttpStatus.OK);
    }


// list bai viet nheu luot xem nhat
    @GetMapping("/views")
    public List<News> getNewsByViews(){
        List<News> newsViews = newsRepository.findTopNews();
        return newsViews;
    }


// find by id
    @GetMapping("{id}")
    public News getNewsById(@PathVariable("id") Integer id){
        Optional<News> optionalNews = newsRepository.findById(id);
        return  optionalNews.get();
    }

//search theo ten
    @GetMapping("/search")
    public List<News> searchNewsByKeyWord(@RequestParam("title") String title){
        List<News> searchNews= newsRepository.findByTitle(title);
        return searchNews;
    }
}
