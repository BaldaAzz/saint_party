package com.example.SaintDima.services;

import com.example.SaintDima.models.Article;
import com.example.SaintDima.models.Image;
import com.example.SaintDima.repositories.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ImageService imageService;

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article getArticleById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Статьи с id:" + id + " не найдено!"));
    }

    public void createOrUpdateArticle(Article article, MultipartFile file) throws IOException {
        Image image = new Image();

        if (!file.isEmpty()) {
            image = imageService.saveImage(file);
        } else {
            image.setFileName("no-photo.png");
            image.setPath("/img/");
        }

        article.setImage(image);
        articleRepository.save(article);
    }

    public void deleteArticle(Long id) {
        // Добавить удаление фото, а так же записи из таблицы images
        articleRepository.deleteById(id);
    }
}
