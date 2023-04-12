package com.practica.josetec.domain.services;

import com.practica.josetec.domain.exceptions.NotEnoughStockException;
import com.practica.josetec.domain.exceptions.ProductNotFoundException;
import com.practica.josetec.adapters.repositories.ProductRepository;
import com.practica.josetec.adapters.repositories.SaleRepository;
import com.practica.josetec.domain.entities.Product;
import com.practica.josetec.domain.entities.Sale;
import com.practica.josetec.domain.entities.SaleDetail;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SaleServiceImplPruebaAntes {
    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public void makeSale(Sale sale) throws NotEnoughStockException, ProductNotFoundException {
        // Restar la cantidad de products vendidos del stock
        for (SaleDetail detail : sale.getSaleDetail()) {
            Product product = productRepository.findById(detail.getProduct().getId())
                    .orElseThrow(() -> new ProductNotFoundException("Producto no encontrado"));
            int cantidadVendida = detail.getQuantity();
            if (product.getStock() < cantidadVendida) {
                throw new NotEnoughStockException("Stock insuficiente para el producto " + product.getName());
            }
            product.setStock(product.getStock() - cantidadVendida);
            productRepository.save(product);
        }
        sale.setDate(LocalDateTime.now());
        // Guardar la venta
        saleRepository.save(sale);
    }
}
