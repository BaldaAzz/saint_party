package com.example.SaintDima.services;

import com.example.SaintDima.models.Image;
import com.example.SaintDima.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;
    public static final Logger LOGGER = LoggerFactory.getLogger(ImageService.class);
    private final String UPLOAD_DIR = "target/classes/static/uploads/";
    private final String PATH = "/uploads/";
    private final String DEFAULT_IMAGE_NAME = "no-photo.png";
    private final String DEFAULT_PATH = "/img/";

    public Image saveImage(MultipartFile file) {
        Image image = new Image();

        if (file.isEmpty()) {
            image.setFileName(DEFAULT_IMAGE_NAME);
            image.setPath(DEFAULT_PATH);

        } else {

            Path uploadPath = Paths.get(UPLOAD_DIR);
            try {
                // Создаем директорию и все родительские папки
                Files.createDirectories(uploadPath);
            } catch (IOException e) {
                LOGGER.info("Директория уже создана!");
            }

            LocalDateTime now = LocalDateTime.now();

            // Определяем формат без двоеточий
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");

            // Форматируем текущее время
            String formattedDateTime = now.format(formatter);
            String name = formattedDateTime + file.getOriginalFilename();
            try {
                // Сохраняем файл
                Path filePath = uploadPath.resolve(name);
                Files.write(filePath, file.getBytes());
            } catch (IOException e) {
                LOGGER.info("Произошла ошибка при сохранении изображения!");
            }

            image.setFileName(name);
            image.setPath(PATH);
        }

        return image;
    }

    public void deleteImage(Image image) throws IOException {

        imageRepository.delete(image);

        if (image.getPath().equals(DEFAULT_PATH)) {
            return;
        }

        Path filePath= Paths.get(UPLOAD_DIR).resolve(image.getFileName());
        Files.delete(filePath);
    }
}
