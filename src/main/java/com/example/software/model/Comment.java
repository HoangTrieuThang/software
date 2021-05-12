package com.example.software.model;

import lombok.*;
import org.w3c.dom.Text;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue
    @Column(name="comment_id")
    private int commentId;
    @Column(name="comment_content")
    private String commentContent;
    @Column(name="lever")
    private int lever;
    @Column(name="parent_id")
    private int parentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "news_id", nullable = false)
    private News news;
}
