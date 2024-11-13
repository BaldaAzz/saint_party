package com.example.SaintDima.repositories;

import com.example.SaintDima.models.Prayer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrayerRepository extends JpaRepository<Prayer, Long> {
}
