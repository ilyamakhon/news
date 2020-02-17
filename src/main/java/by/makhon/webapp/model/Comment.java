package by.makhon.webapp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Component
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "user_id")
    @Size(min = 1, max = 20)
    private Long userID;

    @NotBlank
    @Column(name = "comment_content")
    @Size(min = 1, max = 255)
    private String commentContent;
}
