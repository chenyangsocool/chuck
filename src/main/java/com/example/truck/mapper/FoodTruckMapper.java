package com.example.truck.mapper;

import com.example.truck.common.mybatis.entity.Page;
import com.example.truck.entity.FoodTruck;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * food truck info table Mapper interface
 * </p>
 *
 * @author YoungChen
 * @since 2024-10-08
 */
@Mapper
public interface FoodTruckMapper extends BaseMapper<FoodTruck> {

    void insertWithLocation(FoodTruck foodTruck);

    void updateWithLocation(FoodTruck foodTruck);

    Page<FoodTruck> getPage(Page<FoodTruck> page);
}
