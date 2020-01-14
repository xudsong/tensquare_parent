package com.tensquare.recruit.service;

import com.tensquare.base.utils.IdWorker;
import com.tensquare.recruit.dao.RecruitDao;
import com.tensquare.recruit.pojo.Recruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class RecruitService {

    @Autowired
    private RecruitDao recruitDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询全部职位
     * @return
     */
    public List<Recruit> findAll(){
        return recruitDao.findAll();
    }

    /**
     * 根据ID查询职位
     * @param id
     * @return
     */
    public Recruit findById(String id){
        //从缓存中提取
        Recruit recruit = (Recruit) redisTemplate.opsForValue().get("recruit_"+id);
        //如果缓存没有则到数据库查询并放入缓存
        if (recruit == null){
            recruit = recruitDao.findById(id).get();
            redisTemplate.opsForValue().set("recruit_"+id,recruit,1, TimeUnit.DAYS);
        }
        return recruit;
    }

    /**
     * 增加职位
     * @param recruit
     */
    public void add(Recruit recruit){
        recruit.setId( idWorker.nextId()+"" );//设置ID
        recruitDao.save(recruit);
    }

    /**
     * 修改职位
     * @param recruit
     */
    public void update(Recruit recruit){
        //删除缓存
        redisTemplate.delete("recruit_"+recruit.getId());
        recruitDao.save(recruit);
    }

    /**
     * 删除职位
     * @param id
     */
    public void deleteById(String id){
        //删除缓存
        redisTemplate.delete("recruit_"+id);
        recruitDao.deleteById(id);
    }

    /**
     * 根据状态查询
     * @param state
     * @return
     */
    public List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state){
        return recruitDao.findTop4ByStateOrderByCreatetimeDesc(state);
    }

    /**
     * 最新职位列表
     * @return
     */
    public List<Recruit> newlist(){
        return recruitDao.findTop12ByStateNotOrderByCreatetimeDesc("0");
    }

}
