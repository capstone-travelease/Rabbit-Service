package com.RabbitService.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class MessageDTO {
    @NotNull
    private Integer hotelId;
    @NotNull
    private Integer userId;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private Date checkinDate;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private  Date checkoutDate;

    @NotNull
    @NotEmpty
    private List<ProductListDTO> productList;

    @NotNull
    @NotBlank
    private String taxes;

    private String coupon;
    private String note;

    @NotNull
    private  Integer totalPrice;
    @NotNull
    private Integer accountId;
}
