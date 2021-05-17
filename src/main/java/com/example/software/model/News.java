package com.example.software.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.w3c.dom.Text;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="news_id")
    private int newsId;
    @Column(name="title")
    private String title;
    @Column(name="content")
    private String content;
    @Column(name="news_desc")
    private String newsDesc;
    @Column(name="news_source")
    private String newsSource;
    @Column(name="news_date")
    private Date newsDate;
    @Column(name="like_count")
    private int likeCount;
    @Column(name="title_img")
    private String titleImg;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="news_kind_id", nullable=false)
    @JsonIgnore
    private NewsKind newsKind;

    public News(int newsId, String title, String content, String newsDesc, String newsSource, Date newsDate, int likeCount, String titleImg, NewsKind newsKind) {
        this.newsId = newsId;
        this.title = title;
        this.content = content;
        this.newsDesc = newsDesc;
        this.newsSource = newsSource;
        this.newsDate = newsDate;
        this.likeCount = likeCount;
        this.titleImg = titleImg;
        this.newsKind = newsKind;
    }

    public News() {
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNewsDesc() {
        return newsDesc;
    }

    public void setNewsDesc(String newsDesc) {
        this.newsDesc = newsDesc;
    }

    public String getNewsSource() {
        return newsSource;
    }

    public void setNewsSource(String newsSource) {
        this.newsSource = newsSource;
    }

    public Date getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(Date newsDate) {
        this.newsDate = newsDate;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getTitleImg() {
        return titleImg;
    }

    public void setTitleImg(String titleImg) {
        this.titleImg = titleImg;
    }

    public NewsKind getNewsKind() {
        return newsKind;
    }

    public void setNewsKind(NewsKind newsKind) {
        this.newsKind = newsKind;
    }
}
