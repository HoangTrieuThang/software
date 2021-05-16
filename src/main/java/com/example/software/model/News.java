package com.example.software.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.w3c.dom.Text;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
    }
