package com.example.truck.service;

import com.example.truck.common.mybatis.entity.Page;
import com.example.truck.entity.FoodTruck;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.truck.entity.common.FoodTruckModel;

/**
 * <p>
 * food truck info table service interface class
 * </p>
 *
 * @author YoungChen
 * @since 2024-10-08
 */
public interface IFoodTruckService extends IService<FoodTruck> {

    void insert(FoodTruckModel foodTruckModel);

    void update(FoodTruckModel foodTruckModel, FoodTruck foodTruck);

    Page<FoodTruck> getPage(Page<FoodTruck> page);
}
