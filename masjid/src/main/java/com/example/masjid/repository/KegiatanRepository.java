package com.example.masjid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.masjid.entity.KegiatanEntity;

@Repository
public interface KegiatanRepository extends JpaRepository<KegiatanEntity, Integer> {

}
