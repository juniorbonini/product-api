package com.api.product.controller;

import java.util.List;
import com.api.product.model.Product;
import com.api.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
  @Autowired
  private ProductService service;

  @PostMapping()
  public void create(@RequestBody Product product) {
    service.create(product);
  }

  @GetMapping
  public List<Product> findAll() {
    return service.getAll();
  }

  @GetMapping("/{id}")
  public Product findOne(@PathVariable Long id) {
    return service.findById(id);
  }

  @PutMapping("/{id}")
  public Product updateOne(@PathVariable Long id, @RequestBody Product productDetails) {
    return service.update(id, productDetails);
  }

  @DeleteMapping("/{id}")
  public void deleteOne(@PathVariable Long id) {
    service.delete(id);
  }
}
