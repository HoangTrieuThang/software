package com.example.software.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "news_kind")
public class NewsKind {
    @Id
    @GeneratedValue
    @Column(name="news_kind_id")
    private int newsKindId;
    @Column(name="news_kind_name")
    private String newsKindName;

    @OneToMany(mappedBy="newsKind",fetch=FetchType.LAZY)
    private Collection<News> news;

}
