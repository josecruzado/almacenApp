package com.practica.josetec.domain.services;

import com.practica.josetec.adapters.repositories.SaleRepository;
import com.practica.josetec.domain.entities.Sale;
import com.practica.josetec.domain.exceptions.InvalidSaleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SaleServiceImpl {
    @Autowired
    private SaleRepository saleRepository;

    public void registerSale(Sale sale) throws InvalidSaleException {
        validateSale(sale);
        sale.setDate(LocalDateTime.now());
        saleRepository.save(sale);
    }

    private void validateSale(Sale sale) throws InvalidSaleException {
        if (sale.getSaleDetails().get(0).getQuantity() <= 0) {
            throw new InvalidSaleException("Quantity must be greater than 0");
        }
    }

}