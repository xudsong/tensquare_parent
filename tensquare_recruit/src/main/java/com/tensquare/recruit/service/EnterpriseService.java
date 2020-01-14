package com.tensquare.recruit.service;

import com.tensquare.base.utils.IdWorker;
import com.tensquare.recruit.dao.EnterpriseDao;
import com.tensquare.recruit.pojo.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseDao enterpriseDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询全部企业
     * @return
     */
    public List<Enterprise> findAll(){
        return enterpriseDao.findAll();
    }

    /**
     * 根据ID查询企业
     * 此方法第一次运行，在缓存中没有找到对应的value和key，则将查询结果放入缓存
     * @param id
     * @return
     * @Cacheable
     * 使用这个注解的方法在执行后会缓存其返回结果
     */
    @Cacheable(value = "enterprise",key = "#id")
    public Enterprise findById(String id){
        return enterpriseDao.findById(id).get();
    }

    /**
     * 增加企业
     * @param enterprise
     */
    public void add(Enterprise enterprise){
        enterprise.setId( idWorker.nextId()+"" );//设置ID
        enterpriseDao.save(enterprise);
    }

    /**
     * 修改企业
     * @param enterprise
     * @CacheEvict
     * 使用这个注解的方法在其执行前或执行后移除Spring Cache中的某些元素
     */
    @CacheEvict(value = "enterprise",key = "#enterprise.id")
    public void update(Enterprise enterprise){
        enterpriseDao.save(enterprise);
    }

    /**
     * 删除企业
     * @param id
     * @CacheEvict
     * 使用这个注解的方法在其执行前或执行后移除Spring Cache中的某些元素
     */
    @CacheEvict(value = "enterprise",key = "#id")
    public void deleteById(String id){
        //删除缓存
        redisTemplate.delete("enterprise_"+id);
        enterpriseDao.deleteById(id);
    }

    /**
     * 热门企业列表
     * @return
     */
    public List<Enterprise> hotlist(){
        return enterpriseDao.findByIshot("1");
    }

}
