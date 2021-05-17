package com.example.software.repository;

import com.example.software.model.NewsKind;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsKindRepository extends JpaRepository<NewsKind, Integer> {
    @Override
    List<NewsKind> findAll();

    NewsKind findAllByNewsKindId(Integer newKindId);

    @Query(value = "select * from news_kind where news_kind_name like %:newsKindName%", nativeQuery = true)
    Page<NewsKind> list(String newsKindName, Pageable pageable);
    void deleteByNewsKindId(int id);
//    List<NewsKind> findNewsKindByNews_kindAndNews_kind_name( final int news_kind, final String news_kind_name);
    
}
