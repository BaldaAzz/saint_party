package com.example.SaintDima.dto;


import com.example.SaintDima.models.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO {

    private Long id;
    private String title;
    private String content;
    private String imageUrl;
}
