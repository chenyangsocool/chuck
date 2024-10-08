package com.example.truck.common.mybatis.util;

import cn.hutool.core.net.URLDecoder;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.example.truck.common.mybatis.entity.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * page util
 */
public class PageUtil {

    /**
     * generate order items
     *
     * @param order  order param string
     * @param fields field names that need to be sorted
     * @return order items
     */
    public static List<OrderItem> generateOrderItemList(String order, String... fields) {
        JSONArray orderJsonArray = JSONUtil.parseArray(StrUtil.toUnderlineCase(urlParamDecode(order)));
        List<OrderItem> orderItemList = new ArrayList<>();
        orderJsonArray.forEach(item -> {
            for (String field : fields) {
                if (((JSONObject) item).containsValue(field)) {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setColumn(field);
                    orderItem.setAsc(((JSONObject) item).getBool("asc"));
                    orderItemList.add(orderItem);
                }
            }
        });
        return orderItemList;
    }

    /**
     * get page
     *
     * @param current       current page number
     * @param pageSize      page size
     * @param filter        filter params
     * @param beanClass     class type
     * @param orderItemList order param
     * @param <T>           T
     * @return page
     */
    public static <T> Page<T> getPage(Long current, Long pageSize, String filter, Class<T> beanClass, List<OrderItem> orderItemList) {
        if (current == null || current <= 0) {
            current = 1L;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 10L;
        }
        return new Page<>(current, pageSize, urlParamDecode(filter), beanClass, orderItemList);
    }


    /**
     * decode url to json string
     *
     * @param param url params
     * @return json string
     */
    public static String urlParamDecode(String param) {
        if (StrUtil.isBlank(param)) {
            return "{}";
        }
        return URLDecoder.decode(param, CharsetUtil.CHARSET_UTF_8);
    }
}
