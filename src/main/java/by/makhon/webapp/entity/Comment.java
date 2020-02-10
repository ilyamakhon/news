package by.makhon.webapp.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Component
@Getter
@Setter
@Table(name = "comments")
public class Comment {
    private Long commentID;
    private String commentContent;
    private Long userID;
}
