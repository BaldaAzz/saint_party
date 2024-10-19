package com.example.SaintDima.repositories;

import com.example.SaintDima.models.Saint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaintRepository extends JpaRepository<Saint, Long> {
}
