package com.example.SaintDima.repositories;

import com.example.SaintDima.models.SaintPerson;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SaintPersonRepository extends JpaRepository<SaintPerson, Long> {

    @Query("SELECT sp FROM SaintPerson sp " +
            "WHERE (:placeOfBirth IS NULL OR sp.placeOfBirth = :placeOfBirth)" +
            "AND  (:minDateOfBirth IS NULL OR sp.dateOfBirth >= :minDateOfBirth)" +
            "AND  (:maxDateOfBirth IS NULL OR sp.dateOfBirth <= :maxDateOfBirth)")
    Page<SaintPerson> findByFilters(@Param("placeOfBirth") String placeOfBirth,
                                    @Param("minDateOfBirth") Integer minDateOfBirth,
                                    @Param("maxDateOfBirth") Integer maxDateOfBirth,
                                    Pageable pageable);
}
