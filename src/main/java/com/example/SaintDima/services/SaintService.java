package com.example.SaintDima.services;

import com.example.SaintDima.models.Saint;
import com.example.SaintDima.repositories.SaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SaintService {

    @Autowired
    private SaintRepository saintRepository;

    public Saint createSaintBiography(Saint saint) {
       return saintRepository.save(saint);
    }

    public Saint getByIdSaintBiography(Long id) {
        return saintRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Статья с id "+ id +" не найдена!"));
    }

    public List<Saint> getAllSaintsBiography() {
        return saintRepository.findAll();
    }

    public Saint updateSaintBiography(Long id, Saint updatedSaint) {
        Saint executedSaint = saintRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Статья с id "+ id +" не найдена!"));

        executedSaint.setName(updatedSaint.getName());
        executedSaint.setSurname(updatedSaint.getSurname());
        executedSaint.setFathersName(updatedSaint.getFathersName());
        executedSaint.setBiography(updatedSaint.getBiography());
        executedSaint.setDateOfBirth(updatedSaint.getDateOfBirth());
        executedSaint.setDateOfDeath(updatedSaint.getDateOfDeath());
        executedSaint.setPicturePath(updatedSaint.getPicturePath());

        return saintRepository.save(executedSaint);
    }

    public void deleteSaintBiography(Long id) {
        saintRepository.deleteById(id);
    }
}
