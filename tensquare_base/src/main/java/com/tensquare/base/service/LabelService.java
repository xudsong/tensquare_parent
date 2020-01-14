package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import com.tensquare.base.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class LabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询全部标签
     * @return
     */
    public List<Label> findAll(){
        return labelDao.findAll();
    }

    /**
     * 根据ID查询标签
     * @param id
     * @return
     */
    public Label findById(String id){
        //从缓存中提取
        Label label = (Label) redisTemplate.opsForValue().get("label_"+id);
        //如果缓存没有则到数据库查询并放入缓存
        if (label == null){
            label = labelDao.findById(id).get();
            redisTemplate.opsForValue().set("label_"+id,label,1, TimeUnit.DAYS);
        }
        return label;
    }

    /**
     * 增加标签
     * @param label
     */
    public void add(Label label){
        label.setId( idWorker.nextId()+"" );//设置ID
        labelDao.save(label);
    }

    /**
     * 修改标签
     * @param label
     */
    public void update(Label label){
        //删除缓存
        redisTemplate.delete("label_"+label.getId());
        labelDao.save(label);
    }

    /**
     * 删除标签
     * @param id
     */
    public void deleteById(String id){
        //删除缓存
        redisTemplate.delete("label_"+id);
        labelDao.deleteById(id);
    }

}
