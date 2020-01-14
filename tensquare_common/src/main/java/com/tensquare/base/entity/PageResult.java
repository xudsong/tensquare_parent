package com.tensquare.base.entity;

import lombok.Data;

import java.util.List;

/**
 * 分页结果
 */
@Data
public class PageResult<T> {

    private Long total;
    private List<T> rows;

    public PageResult(Long total, List<T> rows){
        super();
        this.total = total;
        this.rows = rows;
    }

}
