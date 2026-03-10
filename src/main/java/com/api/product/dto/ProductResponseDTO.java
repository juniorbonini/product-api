package com.api.product.dto;

import java.time.LocalDateTime;

import com.api.product.enums.ProductType;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@JsonPropertyOrder({
  "id",
  "name",
  "description",
  "priceInCents",
  "inStockQuantity",
  "available",
  "type",
  "createdAt",
  "updatedAt"
})

public class ProductResponseDTO {
  private Long id;
  private String name;
  private String description;
  private Integer priceInCents;
  private Integer inStockQuantity;
  private Boolean available;
  private ProductType type;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
