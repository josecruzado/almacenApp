package com.practica.josetec.application.services;

import com.practica.josetec.adapters.converters.ProductMapper;
import com.practica.josetec.adapters.repositories.ProductRepository;
import com.practica.josetec.application.dtos.ProductDto;
import com.practica.josetec.domain.entities.Product;
import com.practica.josetec.domain.exceptions.ProductNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    @Transactional
    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        productRepository.save(product);
        return productDto;
    }

    @Override
    public void deleteProduct(Long idProduct) throws ProductNotFoundException {
        Optional<Product> optionalProducto = productRepository.findById(idProduct);
        if (optionalProducto.isPresent()) {
            Product producto = optionalProducto.get();
            productRepository.delete(producto);
        } else {
            throw new ProductNotFoundException("Producto no encontrado con el id: " + idProduct);
        }
    }

    @Override
    @Transactional
    public ProductDto updateProduct(Long id, ProductDto productDto) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            // Actualizamos los campos del producto con los datos del DTO
            product.setName(productDto.getName());
            product.setDescription(productDto.getDescription());
            product.setPrice(productDto.getPrice());
            product.setStock(productDto.getStock());
            // Guardamos los cambios en la base de datos
            productRepository.save(product);
            return productMapper.toDto(product);
        } else {
            throw new ProductNotFoundException("Product not found with id " + id);
        }
    }

    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    public ProductDto getProductById(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        Product product = optionalProduct.orElseThrow(() -> new ProductNotFoundException(String.valueOf(id)));
        return productMapper.toDto(product);
    }

}

