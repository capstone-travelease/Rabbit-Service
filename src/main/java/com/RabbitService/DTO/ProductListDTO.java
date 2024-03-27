package com.RabbitService.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductListDTO {
    private Integer roomId;
    private Integer roomQuantity;
    private Integer roomPrice;
}
