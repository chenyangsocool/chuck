package com.example.truck.common.mybatis.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

@Component
public class MybatisPlusObjectConfig implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
    }

    @Override
    public void updateFill(MetaObject metaObject) {
    }
}
