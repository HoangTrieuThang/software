package com.example.software.services.impl;

import com.example.software.model.News;
import com.example.software.model.NewsKind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsService implements com.example.software.services.NewsService {

    @Autowired


    @Override
    public List<News> getAllNews() {
        return null;
    }

    @Override
    public Page<News> listNews(PageRequest pageRequest, String title) {
        return null;
    }

    @Override
    public NewsKind findNewsByNewsId(Integer newsId) {
        return null;
    }

    @Override
    public News create(News news) {
        return null;
    }

    @Override
    public News update(Integer id, News news) throws Exception {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
