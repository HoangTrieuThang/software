package com.example.software.controller.usercontroller;

import com.example.software.common.ApiResponse;
import com.example.software.model.News;
import com.example.software.repository.NewsRepository;
import com.example.software.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("date")
    public List<News> getNewsByDate(@PathVariable("news_date")Timestamp news_date){
        List<News> newsList = newsRepository.findByNews_date(news_date);
        return newsList;
    }

    @GetMapping("views")
    public List<News> getNewsByViews(@PathVariable("view_count")int view_count){
        List<News> newsViews = newsRepository.findByView_count(view_count);
        return newsViews;
    }

    @GetMapping("{id}")
    public Optional<News> getNewsById(@PathVariable("id") Integer integer){
        Optional<News> getNewsById = newsRepository.findById(integer);
        return getNewsById;
    }

    @GetMapping("/search/{keyword}")
    public List<News> searchNewsByKeyWord(@PathVariable("keyword") String keyword){
        List<News> searchNews= newsRepository.findByContent(keyword);
        return searchNews;
    }




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
