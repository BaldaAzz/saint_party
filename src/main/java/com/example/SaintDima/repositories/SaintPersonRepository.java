package com.example.SaintDima.repositories;

import com.example.SaintDima.models.SaintPerson;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SaintPersonRepository extends JpaRepository<SaintPerson, Long> {

    @Query("SELECT sp FROM SaintPerson sp " +
            "WHERE (:rank IS NULL OR sp.rank = :rank) " +
            "AND (:region IS NULL OR sp.region = :region) " +
            "AND (:typeOfFeat IS NULL OR sp.typeOfFeat = :typeOfFeat)")
    Page<SaintPerson> findByFilters(@Param("rank") String rank,
                                    @Param("region") String region,
                                    @Param("typeOfFeat") String typeOfFeat,
                                    Pageable pageable);
}
