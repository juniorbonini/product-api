package com.api.product.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductResponseDTO {
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
