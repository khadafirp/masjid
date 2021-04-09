package com.example.masjid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.masjid.entity.JeniskasEntity;

@Repository
public interface JeniskasRepository extends JpaRepository<JeniskasEntity, Integer> {

}
