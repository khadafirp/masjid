package com.example.masjid.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.masjid.entity.DesckasmasukEntity;

@Repository
public interface DesckasmasukRepository extends JpaRepository<DesckasmasukEntity, Integer> {
	@Query("SELECT a FROM DesckasmasukEntity a WHERE a.desc_id=:desc_id")
	public DesckasmasukEntity filter(@RequestParam("desc_id") String desc_id);
}
