package com.xbfinal.myeasyexcel.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Title: DemoData
 * @Author 笑霸fianl
 * @Package com.xbfinal.myeasyexcel.pojo
 * @Date 2023/7/31 9:12
 * @描述: 写excel对象
 */
@Getter
@Setter
@EqualsAndHashCode
public class DemoData {
    @ExcelProperty("奖品名称")
    private String string;
    @ExcelProperty("奖品id")
    private Integer id;

    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String ignore;
}
