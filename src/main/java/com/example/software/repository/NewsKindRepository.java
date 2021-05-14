package com.example.software.repository;

import com.example.software.model.NewsKind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsKindRepository extends JpaRepository<NewsKind, Integer> {
    @Override
    List<NewsKind> findAll();

    NewsKind findAllByNewsKindId(Integer newKindId);

//    List<NewsKind> findNewsKindByNews_kindAndNews_kind_name( final int news_kind, final String news_kind_name);
    
}
