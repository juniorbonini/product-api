package com.api.product.controller;

import java.util.List;
import com.api.product.dto.*;
import jakarta.validation.Valid;
import com.api.product.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
  @Autowired
  private ProductService service;

  @PostMapping()
  public ProductResponseDTO create(@Valid @RequestBody ProductRequestDTO dto) {
    return service.create(dto);
  }

  @GetMapping
  public List<ProductResponseDTO> findAll() {
    return service.getAll();
  }

  @GetMapping("/{id}")
  public ProductResponseDTO findOne(@PathVariable Long id) {
    return service.findById(id);
  }

  @PutMapping("/{id}")
  public ProductResponseDTO updateOne(@PathVariable Long id, @Valid @RequestBody ProductRequestDTO dto) {
    return service.update(id, dto);
  }

  @DeleteMapping("/{id}")
  public void deleteOne(@PathVariable Long id) {
    service.delete(id);
  }
}
