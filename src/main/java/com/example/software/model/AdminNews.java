package com.example.software.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "admin_news")
public class AdminNews {
    @Id
    @GeneratedValue
    private int admin_news_id;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "news_id", nullable = false)
    private News news;
}
