package com.api.product.service;

import java.util.List;
import com.api.product.dto.*;
import java.util.stream.Collectors;
import com.api.product.model.Product;
import org.springframework.stereotype.Service;
import com.api.product.exception.NotFoundException;
import com.api.product.repository.ProductRepository;

@Service
public class ProductService {
  private ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public ProductResponseDTO create(ProductRequestDTO dto) {
    Product product = new Product();
    product.setName(dto.getName());
    product.setPriceInCents(dto.getPriceInCents());

    Product saved = productRepository.save(product);

    return toResponseDTO(saved);
  }

  public List<ProductResponseDTO> getAll() {
    return productRepository.findAll()
        .stream()
        .map(this::toResponseDTO)
        .collect(Collectors.toList());
  }

  public ProductResponseDTO findById(Long id) {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Produto não encontrado"));

    return toResponseDTO(product);
  }

  public ProductResponseDTO update(Long id, ProductRequestDTO productDetails) {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Produto não encontrado"));

    product.setName(productDetails.getName());
    product.setPriceInCents(productDetails.getPriceInCents());

    Product updated = productRepository.save(product);

    return toResponseDTO(updated);
  }

  public void delete(Long id) {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Produto não encontrado"));

    productRepository.delete(product);
  }

  public ProductResponseDTO toResponseDTO(Product product) {
    ProductResponseDTO dto = new ProductResponseDTO();
    dto.setId(product.getId());
    dto.setName(product.getName());
    dto.setPriceInCents(product.getPriceInCents());
    return dto;
  }
}
