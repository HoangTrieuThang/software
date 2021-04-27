package com.example.software.repository;

import com.example.software.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.Text;

import javax.swing.text.AbstractDocument;
import java.util.Date;
import java.util.List;

public interface NewsRepository extends JpaRepository<News,Integer> {

    Iterable<News> findNewsByNews_date(Date news_date);

    Iterable<News> findNewsByContent(Text content);
}
