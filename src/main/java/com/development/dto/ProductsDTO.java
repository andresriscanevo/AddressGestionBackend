package com.development.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsDTO {
    @JsonProperty("product_id")
    private Long product_id;
    @JsonProperty("product_name")
    private String product_name;
    @JsonProperty("category_name")
    private String category_name;
    @JsonProperty("stock")
    private Long stock;
    private boolean active;
}
