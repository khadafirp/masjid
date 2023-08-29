package com.example.masjid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.masjid.entity.KasEntity;

@Repository
public interface KasRepository extends JpaRepository<KasEntity, Integer> {

}
