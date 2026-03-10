package com.api.product.service;

import java.time.LocalDateTime;
import java.util.List;
import com.api.product.dto.*;
import java.util.stream.Collectors;
import com.api.product.model.Product;
import org.springframework.stereotype.Service;
import com.api.product.exception.NotFoundException;
import com.api.product.exception.ProductOutOfStock;
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
    product.setType(dto.getType());
    product.setAvailable(dto.getAvailable());
    product.setCreatedAt(LocalDateTime.now());
    product.setDescription(dto.getDescription());
    product.setUpdatedAt(product.getUpdatedAt());
    product.setPriceInCents(dto.getPriceInCents());
    product.setInStockQuantity(dto.getInStockQuantity());

    if (product.getInStockQuantity() <= 0) {
      throw new ProductOutOfStock("Produto fora de estoque");
    }

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
    product.setDescription(productDetails.getDescription());
    product.setAvailable(productDetails.getAvailable());
    product.setInStockQuantity(productDetails.getInStockQuantity());
    product.setType(productDetails.getType());
    product.setUpdatedAt(LocalDateTime.now());

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
    dto.setType(product.getType());
    dto.setName(product.getName());
    dto.setAvailable(product.getAvailable());
    dto.setCreatedAt(product.getCreatedAt());
    dto.setUpdatedAt(product.getUpdatedAt());
    dto.setDescription(product.getDescription());
    dto.setPriceInCents(product.getPriceInCents());
    dto.setInStockQuantity(product.getInStockQuantity());
    return dto;
  }
}
