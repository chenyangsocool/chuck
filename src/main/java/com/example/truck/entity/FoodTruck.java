package com.example.truck.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.truck.common.mybatis.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serial;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * food truck info table
 * </p>
 *
 * @author YoungChen
 * @since 2024-10-08
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("food_truck")
public class FoodTruck extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * third id
     */
    private String thirdId;

    /**
     * object id
     */
    private Integer objectId;

    /**
     * applicant
     */
    private String applicant;

    /**
     * facility type
     */
    private String facilityType;

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
    private String foodItems;

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
    private Byte priorPermit;

    /**
     * expiration date
     */
    private LocalDateTime expirationDate;

    /**
     * human address
     */
    private String humanAddress;

    /**
     * block lot
     */
    private String blockLot;

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
    private String location;

    /**
     * distance
     */
    @TableField(exist = false)
    private String distance;


    public static final String THIRD_ID = "third_id";

    public static final String OBJECT_ID = "object_id";

    public static final String APPLICANT = "applicant";

    public static final String FACILITY_TYPE = "facility_type";

    public static final String CNN = "cnn";

    public static final String ADDRESS = "address";

    public static final String PERMIT = "permit";

    public static final String STATUS = "status";

    public static final String FOOD_ITEMS = "food_items";

    public static final String LONGITUDE = "longitude";

    public static final String LATITUDE = "latitude";

    public static final String SCHEDULE = "schedule";

    public static final String APPROVED = "approved";

    public static final String RECEIVED = "received";

    public static final String PRIOR_PERMIT = "prior_permit";

    public static final String EXPIRATION_DATE = "expiration_date";

    public static final String HUMAN_ADDRESS = "human_address";

    public static final String BLOCK_LOT = "block_lot";

    public static final String BLOCK = "block";

    public static final String LOT = "lot";

    public static final String X = "x";

    public static final String Y = "y";

    public static final String LOCATION = "location";

    public static final String DISTANCE = "distance";
}
