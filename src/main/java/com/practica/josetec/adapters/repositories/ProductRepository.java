package com.practica.josetec.adapters.repositories;

import com.practica.josetec.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    ArrayList<Product> findByName(String name);
}
