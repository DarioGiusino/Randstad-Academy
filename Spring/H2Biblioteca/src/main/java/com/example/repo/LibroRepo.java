package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Libro;


public interface LibroRepo extends JpaRepository<Libro, Long>{
}

