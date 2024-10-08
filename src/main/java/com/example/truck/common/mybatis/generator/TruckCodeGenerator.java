package com.example.truck.common.mybatis.generator;

import lombok.SneakyThrows;

import java.lang.reflect.Method;

/**
 * Truck code generator
 */
public class TruckCodeGenerator extends CodeGenerator {

    @SneakyThrows
    public static void main(String[] args) {
        Method method = CodeGenerator.class.getMethod("main", String[].class);
        String[] info = {"truck", "com.example"};
        method.invoke(null, (Object) info);
    }
}
