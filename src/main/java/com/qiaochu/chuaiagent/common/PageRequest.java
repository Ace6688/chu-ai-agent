package com.qiaochu.chuaiagent.common;

import lombok.Data;

/**
 * 通用分页请求包装类
 */
@Data
public class PageRequest {

    /**
     * 当前页号
     */
    private int current =1;

    /**
     * 每页条数
     */
    private int pageSize = 10;

    /**
     * 排序字段
     */
    private String sortField ;

    /**
     * 排序顺序（默认降序）
     */
    private String sortOrder="descend";


}
