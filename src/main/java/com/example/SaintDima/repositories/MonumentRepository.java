package com.example.SaintDima.repositories;

import com.example.SaintDima.models.Monument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonumentRepository extends JpaRepository<Monument, Long> {
}
