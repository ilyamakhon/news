package by.makhon.webapp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Component
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "user_id")
    @Size(min = 1, max = 20)
    private Long userID;

    @NotBlank
    @Column(name = "title")
    @Size(min = 1, max = 100)
    private String title;

    @NotBlank
    @Column(name = "content")
    @Size(min = 1, max = 255)
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "pic_url")
    @Size(min = 1, max = 255)
    private String picURL;
}
