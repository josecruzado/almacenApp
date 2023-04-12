package com.practica.josetec.domain.services;

import com.practica.josetec.domain.exceptions.InvalidSaleException;
import com.practica.josetec.domain.exceptions.NotEnoughStockException;
import com.practica.josetec.domain.exceptions.ProductNotFoundException;
import com.practica.josetec.domain.entities.Sale;

public interface SaleService {
    //lOGICA DE NEGOCIO DE LA APP
    public void registerSale(Sale sale) throws InvalidSaleException;
}
