package com.example.software.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@ToString
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

}
