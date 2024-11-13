package com.example.SaintDima.services;

import com.example.SaintDima.models.Prayer;
import com.example.SaintDima.repositories.PrayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PrayerService {

    @Autowired
    private PrayerRepository prayerRepository;

    public List<Prayer> getPrayers(int page, int size) {
        return prayerRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    public Prayer getPrayersById(Long id) {
        return prayerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Молитвы с id " + id + " не найдено!"));
    }
}
