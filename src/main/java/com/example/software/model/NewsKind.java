package com.example.software.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "news_kind")
public class NewsKind {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="news_kind_id")
    private int newsKindId;
    @Column(name="news_kind_name")
    private String newsKindName;

    @OneToMany(mappedBy="newsKind",fetch=FetchType.LAZY,cascade = {CascadeType.ALL,CascadeType.PERSIST})
    private Collection<News> news;

    public NewsKind(int newsKindId, String newsKindName, Collection<News> news) {
        this.newsKindId = newsKindId;
        this.newsKindName = newsKindName;
        this.news = news;
    }

    public NewsKind() {
    }

    public int getNewsKindId() {
        return newsKindId;
    }

    public void setNewsKindId(int newsKindId) {
        this.newsKindId = newsKindId;
    }

    public String getNewsKindName() {
        return newsKindName;
    }

    public void setNewsKindName(String newsKindName) {
        this.newsKindName = newsKindName;
    }

    public Collection<News> getNews() {
        return news;
    }

    public void setNews(Collection<News> news) {
        this.news = news;
    }
}
