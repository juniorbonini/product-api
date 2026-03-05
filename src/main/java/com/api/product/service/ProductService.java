package com.api.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.product.model.Product;
import com.api.product.repository.ProductRepository;

@Service
public class ProductService {
  private ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public void create(Product product) {
    productRepository.save(product);
  }

  public List<Product> getAll() {
    return productRepository.findAll();
  }

  public Product findById(Long id) {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

    return product;
  }

  public Product update(Long id, Product productDetails) {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

    product.setName(productDetails.getName());
    product.setPriceInCents(productDetails.getPriceInCents());

    return productRepository.save(product);
  }

  public void delete(Long id) {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

    productRepository.delete(product);
  }
}
