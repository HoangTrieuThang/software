package com.example.software.repository;

import com.example.software.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.security.Timestamp;
import java.util.List;
import java.util.Optional;


public interface NewsRepository extends JpaRepository<News,Integer> {

    @Override
    List<News> findAll();

    @Query(value = "select * from news order by news_date desc limit 10", nativeQuery = true)
    List<News> findByNews_date(Timestamp news_date);

    @Query(value = "select * from news order by view_count desc limit 10", nativeQuery = true)
    List<News> findByView_count(int view_count);

    @Override
    Optional<News> findById(Integer integer);

    List<News> findByContent(String keyword);
}