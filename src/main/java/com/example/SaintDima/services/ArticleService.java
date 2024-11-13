package com.example.SaintDima.services;

import com.example.SaintDima.models.Article;
import com.example.SaintDima.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getArticles(int page, int size) {
        return articleRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    public Article getArticleById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Статьи с id:" + id + " не найдено!"));
    }
}
