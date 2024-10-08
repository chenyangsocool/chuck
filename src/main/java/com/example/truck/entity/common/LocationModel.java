package com.example.truck.entity.common;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Accessors(chain = true)
public class LocationModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * longitude
     */
    private BigDecimal longitude;

    /**
     * latitude
     */
    private BigDecimal latitude;

    /**
     * human_address
     */
    private String human_address;
}
