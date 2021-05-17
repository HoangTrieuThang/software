package com.example.software.repository;

import com.example.software.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface NewsRepository extends JpaRepository<News,Integer> {

    @Query(value = "select * from news order by news_date desc limit 3", nativeQuery = true)
    List<News> findTopNewsDate();

    @Query(value = "select * from news order by like_count desc limit 10", nativeQuery = true)
    List<News> findTopNews();

    News findByNewsId(Integer id);

    @Query(value = "select * from news where title LIKE %:title%", nativeQuery = true)
    List<News> findByTitle(String title);
    void deleteByNewsId(Integer id);
}