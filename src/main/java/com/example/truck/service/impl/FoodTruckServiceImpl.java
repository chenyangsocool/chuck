package com.example.truck.service.impl;

import com.example.truck.common.mybatis.entity.Page;
import com.example.truck.entity.FoodTruck;
import com.example.truck.entity.common.FoodTruckModel;
import com.example.truck.mapper.FoodTruckMapper;
import com.example.truck.service.IFoodTruckService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * food truck info table service class
 * </p>
 *
 * @author YoungChen
 * @since 2024-10-08
 */
@Service
@RequiredArgsConstructor
public class FoodTruckServiceImpl extends ServiceImpl<FoodTruckMapper, FoodTruck> implements IFoodTruckService {

    private final FoodTruckMapper foodTruckMapper;

    @Override
    public void insert(FoodTruckModel foodTruckModel) {
        FoodTruck foodTruck = new FoodTruck();
        fillFoodTruck(foodTruckModel, foodTruck);
        foodTruckMapper.insertWithLocation(foodTruck);
    }

    @Override
    public void update(FoodTruckModel foodTruckModel, FoodTruck foodTruck) {
        fillFoodTruck(foodTruckModel, foodTruck);
        // foodTruckMapper.updateWithLocation(foodTruck);
    }

    @Override
    public Page<FoodTruck> getPage(Page<FoodTruck> page) {
        return foodTruckMapper.getPage(page);
    }

    private void fillFoodTruck(FoodTruckModel foodTruckModel, FoodTruck foodTruck) {
        foodTruck.setThirdId(foodTruckModel.getId())
                .setObjectId(foodTruckModel.getObjectid())
                .setApplicant(foodTruckModel.getApplicant())
                .setFacilityType(foodTruckModel.getFacilitytype())
                .setCnn(foodTruckModel.getCnn())
                .setAddress(foodTruckModel.getAddress())
                .setPermit(foodTruckModel.getPermit())
                .setStatus(foodTruckModel.getStatus())
                .setFoodItems(foodTruckModel.getFooditems())
                .setLongitude(foodTruckModel.getLongitude())
                .setLatitude(foodTruckModel.getLatitude())
                .setSchedule(foodTruckModel.getSchedule())
                .setApproved(foodTruckModel.getApproved())
                .setReceived(foodTruckModel.getReceived())
                .setPriorPermit(foodTruckModel.getPriorpermit())
                .setExpirationDate(foodTruckModel.getExpirationdate())
                .setBlockLot(foodTruckModel.getBlocklot())
                .setBlock(foodTruckModel.getBlock())
                .setLot(foodTruckModel.getLot())
                .setX(foodTruckModel.getX())
                .setY(foodTruckModel.getY());
        if (foodTruckModel.getLocation() != null) {
            foodTruck.setHumanAddress(foodTruckModel.getLocation().getHuman_address())
                    .setLocation(String.format("POINT(%f %f)", foodTruck.getLongitude(), foodTruck.getLatitude()));
        }
    }
}
