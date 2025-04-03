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

    public void createArticle(Article article, MultipartFile file) throws IOException {

        Image image = imageService.saveImage(file);
        article.setImage(image);
        articleRepository.save(article);

    }

    public void updateArticle(Article article, MultipartFile file) throws IOException {
        Article oldArticle = articleRepository.findById(article.getId()).get();

        Image image = null;

        if (oldArticle.getImage() != null && file.isEmpty()) {
            image = oldArticle.getImage();
        } else {
            image = imageService.saveImage(file);
            image.setId(oldArticle.getId());
            imageService.deleteImage(oldArticle.getImage());
        }

        article.setImage(image);
        articleRepository.save(article);
    }

    public void deleteArticle(Long id) throws IOException {
        Article article = articleRepository.findById(id).get();
        imageService.deleteImage(article.getImage());
        articleRepository.deleteById(id);
    }
}
