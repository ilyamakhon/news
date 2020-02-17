package by.makhon.webapp.controller;

import by.makhon.webapp.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/news")
public class NewsController {
    @Autowired
    NewsRepository newsRepository;


}
