package com.example.software.model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue
    private int history_id;
    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean like;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "news_id")
    private News news;
}
