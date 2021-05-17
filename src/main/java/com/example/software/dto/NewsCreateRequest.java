package com.example.software.dto;

import com.example.software.model.News;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;


public class NewsCreateRequest {
    private String title;
    private String content;
    private MultipartFile file;
    private String newsDesc;
    private String newsSource;
    private Date newsDate;
    private int likeCount;
    private String titleImg;
    private Integer newsKindId;

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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
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

    public Integer getNewsKindId() {
        return newsKindId;
    }

    public void setNewsKindId(Integer newsKindId) {
        this.newsKindId = newsKindId;
    }
}
