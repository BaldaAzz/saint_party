package com.example.SaintDima.services;

import com.example.SaintDima.models.Image;
import com.example.SaintDima.models.SaintPerson;
import com.example.SaintDima.repositories.SaintPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class SaintPersonService {

    @Autowired
    private SaintPersonRepository saintPersonRepository;

    public void createSaintBiography(SaintPerson saintPerson, MultipartFile file) throws IOException {
        Image image;

        if(file.getSize() != 0) {
            image = toImageEntity(file);
            saintPerson.addImageToSaintPerson(image);
            saintPerson.setImage(image);
        }

        saintPersonRepository.save(saintPerson);
    }

    public List<SaintPerson> getListBiographies() {
        return saintPersonRepository.findAll();
    }
//    public SaintPerson getByIdSaintBiography(Long id) {
//        return saintPersonRepository.findById(id).orElseThrow(
//                () -> new NoSuchElementException("Статья с id "+ id +" не найдена!"));
//    }
//
//    public List<SaintPerson> getAllSaintsBiography() {
//        return saintPersonRepository.findAll();
//    }
//
//    public SaintPerson updateSaintBiography(Long id, SaintPerson updatedSaintPerson) {
//        SaintPerson executedSaintPerson = saintPersonRepository.findById(id).orElseThrow(
//                () -> new NoSuchElementException("Статья с id "+ id +" не найдена!"));
//
//        executedSaintPerson.setName(updatedSaintPerson.getName());
//        executedSaintPerson.setSurname(updatedSaintPerson.getSurname());
//        executedSaintPerson.setFathersName(updatedSaintPerson.getFathersName());
//        executedSaintPerson.setBiography(updatedSaintPerson.getBiography());
//        executedSaintPerson.setDateOfBirth(updatedSaintPerson.getDateOfBirth());
//        executedSaintPerson.setDateOfDeath(updatedSaintPerson.getDateOfDeath());
//        executedSaintPerson.setPicturePath(updatedSaintPerson.getPicturePath());
//
//        return saintPersonRepository.save(executedSaintPerson);
//    }
//
//    public void deleteSaintBiography(Long id) {
//        saintPersonRepository.deleteById(id);
//    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }
}
