package com.example.software.services;

import com.example.software.model.News;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public interface NewsService {
    List<News> getAllNews();

//    List<News> getNewsByDate();

}
