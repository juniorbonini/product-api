package com.api.product.model;

import lombok.*;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String type;
  private String name;
  private Boolean available;
  private String description;
  private Integer priceInCents;
  private Integer inStockQuantity;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
