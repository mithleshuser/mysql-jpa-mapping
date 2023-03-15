package com.incture.mysqljpamapping.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartRequest
{
    private double total;
    private String name;
    private String itemId;
    private double itemTotal;
    private int quantity;

}
