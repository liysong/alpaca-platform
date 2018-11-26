package com.alpaca.admin.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * @Auther: song
 * @Date: 2018/11/26 16:17
 * @Description:
 * @Version:1.0.0
 */
public class CustomPage<T>  implements IPage<T> {

    /**
     * 查询数据列表
     */
    private List<T> records = Collections.emptyList();
    /**
     * 总数，当 total 不为 0 时分页插件不会进行 count 查询
     */
    private long total = 0;
    /**
     * 每页显示条数，默认 10
     */
    private long size = 10;
    /**
     * 当前页
     */
    private long current = 1;

    /**
     * 总页数
     */
    private long totalPage;

    /**
     * <p>
     * SQL 排序 ASC 数组
     * </p>
     */
    private String[] ascs;
    /**
     * <p>
     * SQL 排序 DESC 数组
     * </p>
     */
    private String[] descs;
    /**
     * <p>
     * 自动优化 COUNT SQL
     * </p>
     */
    private boolean optimizeCountSql = true;

    public CustomPage() {
        // to do nothing
    }

    /**
     * <p>
     * 分页构造函数
     * </p>
     *
     * @param current 当前页
     * @param size    每页显示条数
     */
    public CustomPage(long current, long size) {
        this(current, size, 0);
    }

    public CustomPage(long current, long size, long total) {
        if (current > 1) {
            this.current = current;
        }
        this.size = size;
        this.total = total;

        setTotalPage();
    }

    /**
     * <p>
     * 是否存在上一页
     * </p>
     *
     * @return true / false
     */
    public boolean hasPrevious() {
        return this.current > 1;
    }

    /**
     * <p>
     * 是否存在下一页
     * </p>
     *
     * @return true / false
     */
    public boolean hasNext() {
        return this.current < this.getPages();
    }

    @Override
    public List<T> getRecords() {
        return this.records;
    }

    @Override
    public CustomPage<T> setRecords(List<T> records) {
        this.records = records;
        setTotalPage();
        return this;
    }

    @Override
    public long getTotal() {
        return this.total;
    }

    @Override
    public CustomPage<T> setTotal(long total) {
        this.total = total;
        setTotalPage();
        return this;
    }

    @Override
    public long getSize() {
        return this.size;
    }

    @Override
    public CustomPage<T> setSize(long size) {
        this.size = size;
        return this;
    }

    @Override
    public long getCurrent() {
        return this.current;
    }

    @Override
    public CustomPage<T> setCurrent(long current) {
        this.current = current;
        setTotalPage();
        return this;
    }

    @Override
    public String[] ascs() {
        return ascs;
    }

    public CustomPage<T> setAscs(List<String> ascs) {
        if (CollectionUtils.isNotEmpty(ascs)) {
            this.ascs = ascs.toArray(new String[0]);
        }
        setTotalPage();
        return this;
    }


    /**
     * <p>
     * 升序
     * </p>
     *
     * @param ascs 多个升序字段
     */
    public CustomPage<T> setAsc(String... ascs) {
        this.ascs = ascs;
        setTotalPage();
        return this;
    }

    @Override
    public String[] descs() {
        return descs;
    }

    public CustomPage<T> setDescs(List<String> descs) {
        if (CollectionUtils.isNotEmpty(descs)) {
            this.descs = descs.toArray(new String[0]);
        }
        setTotalPage();
        return this;
    }

    /**
     * <p>
     * 降序
     * </p>
     *
     * @param descs 多个降序字段
     */
    public CustomPage<T> setDesc(String... descs) {
        this.descs = descs;
        setTotalPage();
        return this;
    }

    @Override
    public boolean optimizeCountSql() {
        return optimizeCountSql;
    }

    public CustomPage<T> setOptimizeCountSql(boolean optimizeCountSql) {
        this.optimizeCountSql = optimizeCountSql;
        setTotalPage();
        return this;
    }

    private  void setTotalPage(){
        if(total%size == 0){
            this.totalPage = total/size;
        }else {
            this.totalPage = total/size +1;
        }
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }
}
