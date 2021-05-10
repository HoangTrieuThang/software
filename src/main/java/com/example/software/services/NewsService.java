package com.example.software.services;

import com.example.software.model.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsService {
    List<News> getAllNews();

    List<News> getNewsByDate();

}
