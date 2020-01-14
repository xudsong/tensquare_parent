package com.tensquare.recruit.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 招聘信息实体类
 */
@Entity
@Table(name = "tb_recruit")
@Data
public class Recruit {
    @Id
    private String id;
    /**
     * 招聘职位
     */
    private String jobname;
    /**
     * 薪资范围
     */
    private String salary;
    /**
     * 经验要求
     */
    private String condition;
    /**
     * 学历要求
     */
    private String education;
    /**
     * 任职方式
     */
    private String type;
    /**
     * 办公地址
     */
    private String address;
    /**
     * 发布日期
     */
    private Date createtime;
    /**
     * 状态
     */
    private String state;
    /**
     * 原网址
     */
    private String url;
    /**
     * 标签
     */
    private String label;
    /**
     * 职位描述
     */
    private String content1;
    /**
     * 职位要求
     */
    private String content2;
}
