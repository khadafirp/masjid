package com.example.masjid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.masjid.entity.LoginEntity;
import com.example.masjid.entity.PengurusEntity;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {

	@Query("SELECT a FROM LoginEntity a WHERE a.email=:email AND a.password=:password")
    public LoginEntity login(@RequestParam("email") String email, @RequestParam("password") String password);
}
