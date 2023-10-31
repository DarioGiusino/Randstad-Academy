package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Membro;

public interface MembroRepo extends JpaRepository<Membro, Long> {

}
