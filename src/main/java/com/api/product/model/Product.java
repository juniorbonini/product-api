package com.api.product.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message =  "O nome do produto não pode ser vazio")
  @Column(nullable = false, length = 100)
  private String name;

  @Positive(message = "O preço do produto precisa ser maior do que 0")
  private Integer priceInCents;
}
