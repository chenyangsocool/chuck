package com.example.truck.controller;

import com.example.truck.common.mybatis.entity.Page;
import com.example.truck.common.mybatis.entity.PageVO;
import com.example.truck.common.mybatis.util.PageUtil;
import com.example.truck.common.result.Result;
import com.example.truck.entity.FoodTruck;
import com.example.truck.service.IFoodTruckService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * food truck info table controller
 * </p>
 *
 * @author YoungChen
 * @since 2024-10-08
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/truck/foodTruck")
public class FoodTruckController {

    private final IFoodTruckService foodTruckService;

    @GetMapping("/getPage")
    public Result<PageVO<FoodTruck>> getPage(Long current, Long pageSize, String filter, String order) {
        Page<FoodTruck> page = PageUtil.getPage(current, pageSize, filter, FoodTruck.class,
                PageUtil.generateOrderItemList(order, FoodTruck.OBJECT_ID, FoodTruck.FACILITY_TYPE, FoodTruck.CNN));
        return Result.ok(foodTruckService.getPage(page).getVO());
    }
}
