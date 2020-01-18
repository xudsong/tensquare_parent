package com.tensquare.recruit.controller;

import com.tensquare.common.entity.Result;
import com.tensquare.common.entity.StatusCode;
import com.tensquare.recruit.pojo.Recruit;
import com.tensquare.recruit.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin //跨域处理
public class RecruitController {

    @Autowired
    private RecruitService recruitService;

    @GetMapping("/recruit/findAll")
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功", recruitService.findAll() );
    }

    @GetMapping("/recruit/findById/{id}")
    public Result findById(@PathVariable String id){
        return new Result(true,StatusCode.OK, "查询成功", recruitService.findById(id));
    }

    @PostMapping("/recruit/add")
    public Result add(@RequestBody Recruit recruit){
        recruitService.add(recruit);
        return new Result(true,StatusCode.OK,"增加成功");
    }

    @PostMapping("/recruit/update/{id}")
    public Result update(@RequestBody Recruit recruit,@PathVariable String id){
        recruit.setId(id);
        recruitService.update(recruit);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    @GetMapping("/recruit/deleteById/{id}")
    public Result deleteById(@PathVariable String id){
        recruitService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    @GetMapping("/recruit/search/recommend")
    public Result recommend(){
        List<Recruit> list = recruitService.findTop4ByStateOrderByCreatetimeDesc("2");
        return new Result(true,StatusCode.OK,"查询成功",list);
    }

    @GetMapping("/recruit/search/newlist")
    public Result newlist(){
        return new Result(true,StatusCode.OK,"查询成功",recruitService.newlist());
    }

}
