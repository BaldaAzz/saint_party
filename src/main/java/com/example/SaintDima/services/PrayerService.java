package com.example.SaintDima.services;


import com.example.SaintDima.models.Prayer;
import com.example.SaintDima.repositories.PrayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PrayerService {

    private final PrayerRepository prayerRepository;

    public void createOrUpdatePrayer(Prayer prayer) {
        prayerRepository.save(prayer);
    }

    public List<Prayer> getAllPrayers() {
        return prayerRepository.findAll();
    }

    public Prayer getPrayerById(Long id) {
        return prayerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Молитва не найдена!"));
    }

    public void deletePrayer(Long id) {
        prayerRepository.deleteById(id);
    }
}
