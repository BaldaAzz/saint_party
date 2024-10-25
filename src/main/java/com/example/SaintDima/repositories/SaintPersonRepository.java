package com.example.SaintDima.repositories;

import com.example.SaintDima.models.SaintPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaintPersonRepository extends JpaRepository<SaintPerson, Long> {
}
