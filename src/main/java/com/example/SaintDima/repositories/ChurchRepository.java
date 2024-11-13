package com.example.SaintDima.repositories;

import com.example.SaintDima.models.Church;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChurchRepository extends JpaRepository<Church, Long> {
}
