package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Prodotto;

@Repository
public interface ProdottoRepo extends JpaRepository<Prodotto, Long> {

    /**
     * Interfaccia che gestisce l'archiviazione e il recupero dei dati relativi all'entità Prodotto.
     * Estende l'interfaccia JpaRepository di Spring Data.
     */
}
