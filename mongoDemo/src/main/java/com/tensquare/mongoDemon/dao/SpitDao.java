package com.tensquare.mongoDemon.dao;

import com.tensquare.mongoDemon.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface SpitDao extends MongoRepository<Spit,String> {

    /**
     * 根据上级ID查询吐槽列表（分页）
     * @param parentid
     * @param pageable
     * @return
     */
    public Page<Spit> findByParentid(String parentid, Pageable pageable);


}
