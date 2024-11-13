package com.example.SaintDima.repositories;

import com.example.SaintDima.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
