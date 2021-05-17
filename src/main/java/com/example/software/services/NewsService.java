package com.example.software.services;

import com.example.software.model.News;
import com.example.software.model.NewsKind;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public interface NewsService {
    List<News> getAllNews();

    Page<News> listNews(PageRequest pageRequest, String title);

    NewsKind findNewsByNewsId (Integer newsId);

    News create(News news);

    News update(Integer id, News news) throws Exception;

    void delete(Integer id);

//    List<News> getNewsByDate();

}
