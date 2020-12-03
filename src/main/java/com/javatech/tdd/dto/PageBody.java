package com.javatech.tdd.dto;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * 统一分页
 * @author baiyu
 * @Desc
 * @date 2020/11/30
 */
@Data
public class PageBody<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Long total;
    private List<T> list;

    /**
     * 将PageHelper分页后的list转为分页信息
     */
    public static <T> PageBody<T> getPageBody(List<T> list) {
        PageBody<T> result = new PageBody<>();

        PageInfo<T> pageInfo = new PageInfo<T>(list);
        result.setTotalPage(pageInfo.getPages());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getList());

        return result;
    }
}
