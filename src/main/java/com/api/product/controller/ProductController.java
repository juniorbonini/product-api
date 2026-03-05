package com.api.product.controller;

import java.util.List;
import com.api.product.model.Product;
import org.springframework.web.bind.annotation.*;
import com.api.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
  @Autowired
  private ProductRepository productRepository;

  @PostMapping()
  public void create(@RequestBody Product product) {
    productRepository.save(product);
  }

  @GetMapping
  public List<Product> findAll() {
    return productRepository.findAll();
  }

  @GetMapping("/{id}")
  public Product findOne(@PathVariable Long id) {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

    return product;
  }

  @PutMapping("/{id}")
  public Product updateOne(@PathVariable Long id, @RequestBody Product productDetails) {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

    product.setName(productDetails.getName());
    product.setPriceInCents(productDetails.getPriceInCents());

    return productRepository.save(product);
  }

  @DeleteMapping("/{id}")
  public void deleteOne(@PathVariable Long id) {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

    productRepository.delete(product);
  }
}
