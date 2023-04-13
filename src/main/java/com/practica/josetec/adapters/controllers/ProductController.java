package com.practica.josetec.adapters.controllers;

import com.practica.josetec.application.dtos.ProductDto;
import com.practica.josetec.application.services.ProductService;
import com.practica.josetec.domain.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productoService;

    @GetMapping("/")
    public List<ProductDto> getAllProducts() {
        return productoService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) throws ProductNotFoundException {
        return productoService.getProductById(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> createProduct(@RequestBody ProductDto productDto) {
        ProductDto createdProduct = productoService.createProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto)
            throws ProductNotFoundException {
        ProductDto updatedProduct = productoService.updateProduct(id, productDto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) throws ProductNotFoundException {
        productoService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
