package com.demo.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by 26725 on 2018/11/20.
 */
@Data
public class ProductVO<T> {
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private String categoryType;
    @JsonProperty("foods")
    private T categoryFoods;

}
