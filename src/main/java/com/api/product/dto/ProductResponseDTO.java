package com.api.product.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductResponseDTO {
  private Long id;
  private String name;
  private Integer priceInCents;
}
