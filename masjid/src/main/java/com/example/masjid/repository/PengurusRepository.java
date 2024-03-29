package com.example.masjid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.masjid.entity.PengurusEntity;

@Repository
public interface PengurusRepository extends JpaRepository<PengurusEntity, Integer> {
	
}
