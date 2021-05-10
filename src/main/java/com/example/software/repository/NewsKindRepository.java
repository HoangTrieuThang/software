package com.example.software.repository;

import com.example.software.model.NewsKind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsKindRepository extends JpaRepository<NewsKind, Integer> {
    @Override
    List<NewsKind> findAll();

     List<NewsKind> findByNews_kindAndNews_kind_name(int news_kind, String news_kind_name);


}
