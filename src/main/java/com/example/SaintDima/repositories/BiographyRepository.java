package com.example.SaintDima.repositories;

import com.example.SaintDima.models.Biography;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BiographyRepository extends JpaRepository<Biography, Long> {

    @Query("SELECT sp FROM Biography sp " +
            "WHERE (:placeOfBirth IS NULL OR sp.placeOfBirth = :placeOfBirth)" +
            "AND  (:minDateOfBirth IS NULL OR sp.dateOfBirth >= :minDateOfBirth)" +
            "AND  (:maxDateOfBirth IS NULL OR sp.dateOfBirth <= :maxDateOfBirth)")
    Page<Biography> findByFilters(@Param("placeOfBirth") String placeOfBirth,
                                  @Param("minDateOfBirth") Integer minDateOfBirth,
                                  @Param("maxDateOfBirth") Integer maxDateOfBirth,
                                  Pageable pageable);
}
