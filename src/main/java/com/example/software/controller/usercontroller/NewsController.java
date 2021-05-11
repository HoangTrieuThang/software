package com.example.software.controller.usercontroller;

import com.example.software.common.ApiResponse;
import com.example.software.model.News;
import com.example.software.repository.NewsRepository;
import com.example.software.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/news")
@CrossOrigin(origins = {"*"})
public class NewsController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private NewsRepository newsRepository;

    @GetMapping("getAlls")
    public ResponseEntity<ApiResponse> getAllNews() {
        ApiResponse object = new ApiResponse();
        List<News> newsList= newsService.getAllNews();
        if(newsList != null) {
            object.setData(newsList);
            object.setCode(200);
            object.setErrors(null);
            object.setStatus(true);
            return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
        }
        return null;
    }

// 2 cai tim theo bai viet moi nhat va nhieu luot xem nhat bi loi 400
//list bai viet moi nhat
    @GetMapping("/date")
    public List<News> getNewsByDate(@RequestParam(value = "news_date")
                                        @DateTimeFormat(pattern = "dd.MM.yyyy") Timestamp news_date){
        List<News> newsList = newsRepository.findByNews_date(news_date);
        return newsList;
    }


// list bai viet nheu luot xem nhat
    @GetMapping("views")
    public List<News> getNewsByViews(@PathVariable("view_count")int view_count){
        List<News> newsViews = newsRepository.findByView_count(view_count);
        return newsViews;
    }


// find by id
    @GetMapping("{id}")
    public Optional<News> getNewsById(@PathVariable("id") Integer integer){
        Optional<News> getNewsById = newsRepository.findById(integer);
        return  getNewsById;
    }

//search theo ten
    @GetMapping("/search/{title}")
    public List<News> searchNewsByKeyWord(@PathVariable("title") String keyword){
        List<News> searchNews= newsRepository.findNewsByTitle(keyword);
        return searchNews;
    }





}
