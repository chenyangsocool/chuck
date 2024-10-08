package com.example.truck.common.mybatis.entity;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Page<T> extends com.baomidou.mybatisplus.extension.plugins.pagination.Page<T> {

    @Serial
    private static final long serialVersionUID = 1L;

    private T filter;

    /**
     * @param current       current page number
     * @param pageSize      page size
     * @param filter        filter params
     * @param beanClass     class type
     * @param orderItemList order param
     */
    public Page(Long current, Long pageSize, String filter, Class<T> beanClass, List<OrderItem> orderItemList) {
        super(current, pageSize);
        this.filter = JSONUtil.toBean(filter, beanClass);
        addOrder(orderItemList);
    }

    public PageVO<T> getVO() {
        return new PageVO<>(this);
    }
}
