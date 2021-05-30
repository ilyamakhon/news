package by.makhon.webapp.controller;

import by.makhon.webapp.dto.NewsDto;
import by.makhon.webapp.entity.NewsEntity;
import by.makhon.webapp.entity.UserEntity;
import by.makhon.webapp.exception.ResourceNotFoundException;
import by.makhon.webapp.repository.NewsRepository;
import by.makhon.webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    private List<NewsEntity> getAllNews() {
        return newsRepository.findAll();
    }

    @GetMapping("/{id}")
    private NewsEntity getNewsById(@PathVariable("id") Long id) {
        return newsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("News", "id", id));
    }

    @PostMapping
    private NewsEntity createNews(@Valid @RequestBody NewsDto newsDto) {
        UserEntity userEntity = userRepository.findById(newsDto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", newsDto.getUserId()));

        return newsRepository.save(
                new NewsEntity().setContent(newsDto.getContent())
                        .setPicUrl(newsDto.getPicUrl())
                        .setTitle(newsDto.getTitle())
                        .setUser(userEntity)
        );
    }

    @PutMapping
    private NewsEntity updateNews(@Valid @RequestBody NewsDto newsDto) {
        NewsEntity news = newsRepository.findById(newsDto.getNewsId())
                .orElseThrow(() -> new ResourceNotFoundException("News", "id", newsDto.getNewsId()));

        return newsRepository.save(
                news.setContent(newsDto.getContent())
                        .setPicUrl(newsDto.getPicUrl())
                        .setTitle(newsDto.getTitle())
                        .setUser(userRepository.findById(newsDto.getUserId())
                                .orElseThrow(() -> new ResourceNotFoundException("User", "id", newsDto.getUserId())))
        );
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteNews(@PathVariable("id") Long id) {
        NewsEntity newsEntity = newsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("News", "id", id));

        newsRepository.delete(newsEntity);

        return ResponseEntity.ok().build();
    }

}
