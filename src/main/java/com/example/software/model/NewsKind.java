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
    private int news_kind;

    @OneToMany(mappedBy="newsKind")
    private Collection<News> news;

}
