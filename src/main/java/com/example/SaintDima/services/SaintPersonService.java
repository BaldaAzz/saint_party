package com.example.SaintDima.services;

import com.example.SaintDima.dto.SaintPersonDTO;
import com.example.SaintDima.models.Image;
import com.example.SaintDima.models.SaintPerson;
import com.example.SaintDima.repositories.SaintPersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SaintPersonService {

    @Autowired
    private SaintPersonRepository saintPersonRepository;

    public void createSaintBiography(String name,
                                     String surName,
                                     String fathersName,
                                     LocalDate dateOfBirth,
                                     LocalDate dateOfDeath,
                                     String biography,
                                     String typeOfFeat,
                                     String region,
                                     String rank,
                                     MultipartFile file) throws IOException {

        SaintPerson saintPerson = createSaintPersonObj(name,
                surName,
                fathersName,
                dateOfBirth,
                dateOfDeath,
                biography,
                typeOfFeat,
                region,
                rank);

        Image image;

        if(file.getSize() != 0) {
            image = toImageEntity(file);
            saintPerson.setImage(image);
        }

        saintPersonRepository.save(saintPerson);
    }

    public List<SaintPersonDTO> getFilteredListBiographies(String rank,
                                                           String region,
                                                           String typeOfFeat,
                                                           int page,
                                                           int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<SaintPerson> saintPersonList = saintPersonRepository.findByFilters(rank, region, typeOfFeat, pageable);
        List<SaintPersonDTO> saintPersonDTOList = new ArrayList<>();

        for(SaintPerson saintPerson : saintPersonList.getContent()) {
            saintPersonDTOList.add(convertToDTO(saintPerson));
        }

        return saintPersonDTOList;
    }

    public SaintPersonDTO getByIdSaintBiography(Long id) {
        SaintPerson saintPerson = saintPersonRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Статья с id "+ id +" не найдена!"));
        return convertToDTO(saintPerson);
    }

    private SaintPerson createSaintPersonObj(String name,
                                             String surName,
                                             String fathersName,
                                             LocalDate dateOfBirth,
                                             LocalDate dateOfDeath,
                                             String biography,
                                             String typeOfFeat,
                                             String region,
                                             String rank) {
        SaintPerson saintPerson = new SaintPerson();
        saintPerson.setName(name);
        saintPerson.setSurname(surName);
        saintPerson.setFathersName(fathersName);
        saintPerson.setDateOfBirth(dateOfBirth);
        saintPerson.setDateOfDeath(dateOfDeath);
        saintPerson.setBiography(biography);
        saintPerson.setTypeOfFeat(typeOfFeat);
        saintPerson.setRegion(region);
        saintPerson.setRank(rank);

        return saintPerson;
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    private SaintPersonDTO convertToDTO(SaintPerson saintPerson) {
        SaintPersonDTO saintPersonDTO = new SaintPersonDTO();
        saintPersonDTO.setId(saintPerson.getId());
        saintPersonDTO.setName(saintPerson.getName());
        saintPersonDTO.setSurname(saintPerson.getSurname());
        saintPersonDTO.setFathersName(saintPerson.getFathersName());
        saintPersonDTO.setDateOfBirth(saintPerson.getDateOfBirth());
        saintPersonDTO.setDateOfDeath(saintPerson.getDateOfDeath());
        saintPersonDTO.setBiography(saintPerson.getBiography());
        saintPersonDTO.setRank(saintPerson.getRank());
        saintPersonDTO.setRegion(saintPerson.getRegion());
        saintPersonDTO.setTypeOfFeat(saintPerson.getTypeOfFeat());
        if(saintPerson.getImage() != null) {
            saintPersonDTO.setImageUrl("api/image/" + saintPerson.getImage().getId());
        }

        return saintPersonDTO;
    }
}
