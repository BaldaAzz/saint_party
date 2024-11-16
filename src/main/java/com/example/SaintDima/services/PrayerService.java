package com.example.SaintDima.services;


import com.example.SaintDima.models.Prayer;
import com.example.SaintDima.repositories.PrayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PrayerService {

    @Autowired
    private PrayerRepository prayerRepository;

    public void createPrayer(String title, String text) {

        Prayer prayer = createPrayerObj(title, text);

        prayerRepository.save(prayer);
    }

    public Prayer getPrayerById(Long id) {

        return prayerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Молитва ваша не найдена!"));
    }

    private Prayer createPrayerObj(String title, String text) {
        Prayer prayer = new Prayer();
        prayer.setTitle(title);
        prayer.setPrayer(text);
        return prayer;
    }
}
