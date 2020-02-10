package by.makhon.webapp.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Component
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    @Size(min = 1, max = 100)
    private String login;

    @NotBlank
    @Column
    @Size(min = 1, max = 100)
    private String role;

    @NotBlank
    @Column
    @Size(min = 1, max = 100)
    private String password;
}
