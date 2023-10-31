package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Saluto;

public interface SalutoRepo extends JpaRepository<Saluto, Long> {

}
