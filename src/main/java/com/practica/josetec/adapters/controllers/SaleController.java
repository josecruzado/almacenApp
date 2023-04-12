package com.practica.josetec.adapters.controllers;

import com.practica.josetec.application.services.ProductService;
import com.practica.josetec.domain.entities.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private ProductService productoService;

    @PostMapping("/")
    public ResponseEntity<?> createSale(@RequestBody Sale sale) {
        Sale newSale = productoService.createSale(sale);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSale);
    }
}
