package com.example.SaintDima.services;

import com.example.SaintDima.models.Biography;
import com.example.SaintDima.models.Image;
import com.example.SaintDima.repositories.BiographyRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BiographyService {

    private final BiographyRepository biographyRepository;
    private final ImageService imageService;

    public Biography getBiographyById(Long id) {
        return biographyRepository.findById(id).orElse(null);
    }

    public List<Biography> getAllBiographies() {
        return biographyRepository.findAll();
    }

    public List<Biography> getFilteredListBiographies(
            String place,
            Integer minBirthDate,
            Integer maxBirthDate,
            int page,
            int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Biography> biographyPage = biographyRepository.findByFilters(place, minBirthDate, maxBirthDate, pageable);
        return biographyPage.getContent();
    }

    public void createBiography(Biography biography, MultipartFile file) {
        Image image = imageService.saveImage(file);
        biography.setImage(image);
        biographyRepository.save(biography);
    }

    public void updateBiography(Biography biography, MultipartFile file) throws IOException {
        Biography oldBiography = biographyRepository.findById(biography.getId()).get();

        Image image;

        if (oldBiography.getImage() != null && file.isEmpty()) {
            image = oldBiography.getImage();
        } else {
            image = imageService.saveImage(file);
            image.setId(oldBiography.getId());
            imageService.deleteImage(oldBiography.getImage());
        }

        biography.setImage(image);
        biographyRepository.save(biography);
    }

    public void deleteBiography(Long id) throws IOException {
        Biography biography = biographyRepository.findById(id).get();
        imageService.deleteImage(biography.getImage());
        biographyRepository.deleteById(id);
    }
}
