package com.tensquare.recruit.dao;

import com.tensquare.recruit.pojo.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 标签数据访问接口
 * JpaRepository提供了基本的增删改查
 * JpaSpecificationExecutor用于做复杂的条件查询
 */
public interface EnterpriseDao extends JpaRepository<Enterprise,String>, JpaSpecificationExecutor<Enterprise> {
    public List<Enterprise> findByIshot(String ishot);
}
