package by.makhon.webapp.controller;

import by.makhon.webapp.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/comments")
public class CommentController {
    @Autowired
    CommentRepository commentRepository;
}
