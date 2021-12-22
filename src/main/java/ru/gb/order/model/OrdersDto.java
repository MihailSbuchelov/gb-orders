package ru.gb.order.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdersDto {
    @JsonProperty(value = "orderId")
    private Long id;
    private Double cost;
}
