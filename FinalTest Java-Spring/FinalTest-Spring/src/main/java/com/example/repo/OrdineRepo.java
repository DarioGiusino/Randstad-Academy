package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Ordine;

@Repository
public interface OrdineRepo extends JpaRepository<Ordine, Long> {

    /**
     * Interfaccia che gestisce l'archiviazione e il recupero dei dati relativi all'entità Ordine.
     * Estende l'interfaccia JpaRepository di Spring Data.
     */
}
