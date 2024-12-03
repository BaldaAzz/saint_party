package com.example.SaintDima.services;

import com.example.SaintDima.dto.ArticleDTO;
import com.example.SaintDima.models.Article;
import com.example.SaintDima.models.Image;
import com.example.SaintDima.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Article getArticleById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Статьи с id:" + id + " не найдено!"));
    }

    public void createArticle(String title,
                              String content,
                              MultipartFile file) throws IOException {
        Article article = createArticleObj(title, content, file);
        articleRepository.save(article);
    }

    private Article createArticleObj(String title,
                                     String content,
                                     MultipartFile file) throws IOException {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);

        Image image;

        if(file.getSize() != 0) {
            image = toImageEntity(file);
            article.setImage(image);
        }

        return article;
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    private ArticleDTO convertToDTO(Article article) {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setId(article.getId());
        articleDTO.setTitle(article.getTitle());
        articleDTO.setContent(article.getContent());

        if(article.getImage() != null) {
            articleDTO.setImageUrl("api/image/" + article.getImage().getId());
        }

        return articleDTO;
    }
}
