package com.practica.josetec.adapters.repositories;

import com.practica.josetec.domain.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
