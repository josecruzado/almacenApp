package com.practica.josetec.adapters.converters;

import com.practica.josetec.application.dtos.ProductDto;
import com.practica.josetec.domain.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto toDto(Product product);

    Product toEntity(ProductDto productDto);
}
