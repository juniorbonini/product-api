package com.api.product.exception;

import java.lang.RuntimeException;

public class ProductOutOfStock extends RuntimeException {
   public ProductOutOfStock(String message) {
      super(message);
   }
}
