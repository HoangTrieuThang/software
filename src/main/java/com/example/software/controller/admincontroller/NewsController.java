package com.example.software.controller.admincontroller;

import com.example.software.model.News;
import com.example.software.model.NewsKind;
import com.example.software.repository.NewsKindRepository;
import com.example.software.services.NewsKindService;
import com.example.software.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("adminNewsController")
@RequestMapping("/api/admin/news")
@CrossOrigin(origins = {"*"})
public class NewsController {

    @Autowired
    private NewsService newsService;

    @PostMapping("/create")
    public ResponseEntity<News> createNews(@RequestBody News news) {
        News news1 = newsService.create(news);
        return ResponseEntity.status(201).body(news1);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<News> updateNews(@PathVariable Integer id,
                                                   @RequestBody News news) throws Exception {
        News news1 = newsService.update(id, news);
        return ResponseEntity.status(200).body(news1);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<News> deleteNews(@PathVariable Integer id) {
        newsService.delete(id);
        return ResponseEntity.status(200).body(null);
    }
}
