package com.alpaca.common.page;

import java.io.Serializable;
import java.util.Map;

/**
 * @Auther: song
 * @Date: 2018/11/26 14:53
 * @Description:
 * @Version:1.0.0
 */
public class PageUtils implements Serializable {

    private int page;

    private int limit;

    public PageUtils() {

    }

    public PageUtils(Map<String,Object> params) {
        //分页参数
        this.page = Integer.parseInt(params.get("page").toString());
        this.limit = Integer.parseInt(params.get("limit").toString());
    }

    public PageUtils(int page, int limit) {
        this.page = page;
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
