package com.tensquare.recruit.dao;

import com.tensquare.recruit.pojo.Enterprise;
import com.tensquare.recruit.pojo.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 标签数据访问接口
 * JpaRepository提供了基本的增删改查
 * JpaSpecificationExecutor用于做复杂的条件查询
 */
public interface RecruitDao extends JpaRepository<Recruit,String>, JpaSpecificationExecutor<Recruit> {

    /**
     * 查询最新职位列表(按创建日期降序排序)
     * @param state
     * @return
     */
    public List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state);

    /**
     * 最新职位列表
     * @param state
     * @return
     */
    public List<Recruit> findTop12ByStateNotOrderByCreatetimeDesc(String state);
}
