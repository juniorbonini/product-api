package com.api.product.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

@Getter
@Setter

public class ProductRequestDTO {
  @NotBlank(message = "O nome do produto não pode ser vazio")
  @Column(nullable = false, length = 100)
  private String name;

  @Positive(message = "O preço do produto precisa ser maior que 0")
  private Integer priceInCents;

  @NotBlank(message = "A descrição deve conter no mínimo 10 caracteres")
  @Column(length = 300)
  private String description;

  @PositiveOrZero(message = "Quantidade em estoque deve ser números positivos")
  private Integer inStockQuantity;
  private Boolean available;
  private String type;
}
