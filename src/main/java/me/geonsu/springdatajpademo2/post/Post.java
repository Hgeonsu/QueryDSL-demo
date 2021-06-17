package me.geonsu.springdatajpademo2.post;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter
@Setter
public class Post {

    @Id @GeneratedValue
    private Long id;

    private String title;

    // 255자를 넘어갈 것 같은 경우
    @Lob
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
}
