package com.example.software.repository;

import com.example.software.model.News;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Text;

import javax.swing.text.AbstractDocument;
import java.util.Date;
import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News,Integer> {

    Iterable<News> findNewsByNews_date(Date news_date);

    Iterable<News> findNewsByContentAllIgnoreCase(Text content);

//    @Query("from news where news_date limit 5 order by ")
//    News newsQuerySearch(Text news_date);


}
