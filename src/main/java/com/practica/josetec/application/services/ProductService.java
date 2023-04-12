package com.practica.josetec.application.services;

import com.practica.josetec.application.dtos.ProductDto;
import com.practica.josetec.domain.entities.Product;
import com.practica.josetec.domain.entities.Sale;
import com.practica.josetec.domain.exceptions.NotEnoughStockException;
import com.practica.josetec.domain.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    //LOGICA DE NEGOCIO DE LA APP
    public ProductDto createProduct(ProductDto productDto);
    public void deleteProduct(Long idProduct) throws ProductNotFoundException;

    public ProductDto updateProduct(Long id, ProductDto productDto) throws ProductNotFoundException;
    public List<ProductDto> getAllProducts();
    public ProductDto getProductById(Long id) throws ProductNotFoundException;
}
