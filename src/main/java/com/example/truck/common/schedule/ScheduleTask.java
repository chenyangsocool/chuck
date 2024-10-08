package com.example.truck.common.schedule;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.truck.entity.FoodTruck;
import com.example.truck.entity.common.FoodTruckModel;
import com.example.truck.service.IFoodTruckService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.List;

/**
 * schedule task
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ScheduleTask {

    private final IFoodTruckService foodTruckService;

    @Scheduled(initialDelay = 15000, fixedRate = 3 * 3600L * 1000L)
    public void syncTruckInfo() {
        try {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            // start sync
            int offset = 0;
            while (true) {
                // query truck info list
                String truckUrl = "https://data.sfgov.org/api/id/rqzj-sfat.json?$query=select *, :id offset " + offset + " limit 100";
                String result = HttpUtil.get(truckUrl).replaceAll(":id", "id");
                List<FoodTruckModel> foodTruckModelList = JSONUtil.toList(result, FoodTruckModel.class);
                if (foodTruckModelList == null || foodTruckModelList.isEmpty()) {
                    break;
                }
                // insert or update truck info to DB
                QueryWrapper<FoodTruck> foodTruckQueryWrapper;
                for (FoodTruckModel foodTruckModel : foodTruckModelList) {
                    foodTruckQueryWrapper = new QueryWrapper<>();
                    foodTruckQueryWrapper.eq(FoodTruck.THIRD_ID, foodTruckModel.getId());
                    FoodTruck foodTruck = foodTruckService.getOne(foodTruckQueryWrapper);
                    if (foodTruck == null) {
                        // insert
                        foodTruckService.insert(foodTruckModel);
                    } else {
                        // update
                        foodTruckService.update(foodTruckModel, foodTruck);
                    }
                }
                offset += 100;
            }
            // end sync
            stopWatch.stop();
            log.info("sync truck info success, took {} ms", stopWatch.getTotalTimeMillis());
        } catch (Exception e) {
            log.error("sync truck info error", e);
        }
    }
}
