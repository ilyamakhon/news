package by.makhon.webapp.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Component
@Getter
@Setter
@Table(name = "news")
public class News {
    private Long id;
    private String title;
    private String content;
    private Date date;
    private String picURL;
}