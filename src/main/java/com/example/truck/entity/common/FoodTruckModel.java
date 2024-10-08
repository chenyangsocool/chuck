package com.example.truck.entity.common;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
public class FoodTruckModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * object id
     */
    private Integer objectid;

    /**
     * applicant
     */
    private String applicant;

    /**
     * facility type
     */
    private String facilitytype;

    /**
     * cnn
     */
    private String cnn;

    /**
     * address
     */
    private String address;

    /**
     * permit
     */
    private String permit;

    /**
     * status
     */
    private String status;

    /**
     * food items
     */
    private String fooditems;

    /**
     * longitude
     */
    private BigDecimal longitude;

    /**
     * latitude
     */
    private BigDecimal latitude;

    /**
     * schedule
     */
    private String schedule;

    /**
     * approved
     */
    private LocalDateTime approved;

    /**
     * received
     */
    private Integer received;

    /**
     * prior permit
     */
    private Byte priorpermit;

    /**
     * expiration date
     */
    private LocalDateTime expirationdate;

    /**
     * block lot
     */
    private String blocklot;

    /**
     * block
     */
    private String block;

    /**
     * lot
     */
    private String lot;

    /**
     * x
     */
    private BigDecimal x;

    /**
     * y
     */
    private BigDecimal y;

    /**
     * location
     */
    private LocationModel location;
}
