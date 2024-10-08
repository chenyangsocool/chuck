package com.example.truck.common.mybatis.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class PageVO<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private List<T> data;

    private Long total;

    private Long pageSize;

    private Long current;

    private Long pages;

    public PageVO(Page<T> page) {
        this.data = page.getRecords();
        this.total = page.getTotal();
        this.pageSize = page.getSize();
        this.current = page.getCurrent();
        this.pages = page.getPages();
    }
}
