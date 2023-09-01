package com.example.masjid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.masjid.entity.JadwalEntity;

@Repository
public interface JadwalRepository extends JpaRepository<JadwalEntity, Integer> {

}
