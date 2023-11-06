package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Cliente;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Long> {

    /**
     * Interfaccia che gestisce l'archiviazione e il recupero dei dati relativi all'entità Cliente.
     * Estende l'interfaccia JpaRepository di Spring Data.
     */
}
