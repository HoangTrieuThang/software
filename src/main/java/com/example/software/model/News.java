package com.example.software.model;

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
    @GeneratedValue
    private int news_id;
    private Text title;
    private Text content;
    private Text news_desc;
    private String news_source;
    private Timestamp news_date;
    private int view_count;
    private int like_count;
    private String title_img;

    @ManyToOne
    @JoinColumn(name="news_kind_id", nullable=false)
    private NewsKind newsKind;

    @OneToMany(mappedBy = "news")
    private Collection<AdminNews> adminNews;

    @OneToMany(mappedBy = "news")
    private Collection<History> histories;

    @OneToMany(mappedBy = "news")
    private Collection<Comment> comments;

}
