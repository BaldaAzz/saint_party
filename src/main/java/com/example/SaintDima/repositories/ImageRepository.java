package com.example.SaintDima.repositories;

import com.example.SaintDima.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
