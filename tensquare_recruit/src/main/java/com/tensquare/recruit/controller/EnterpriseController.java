package com.tensquare.recruit.controller;

import com.tensquare.common.entity.Result;
import com.tensquare.common.entity.StatusCode;
import com.tensquare.recruit.pojo.Enterprise;
import com.tensquare.recruit.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin //跨域处理
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping("/enterprise/findAll")
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功", enterpriseService.findAll() );
    }

    @GetMapping("/enterprise/findById/{id}")
    public Result findById(@PathVariable String id){
        return new Result(true,StatusCode.OK, "查询成功", enterpriseService.findById(id));
    }

    @PostMapping("/enterprise/add")
    public Result add(@RequestBody Enterprise enterprise){
        enterpriseService.add(enterprise);
        return new Result(true,StatusCode.OK,"增加成功");
    }

    @PostMapping("/enterprise/update/{id}")
    public Result update(@RequestBody Enterprise enterprise,@PathVariable String id){
        enterprise.setId(id);
        enterpriseService.update(enterprise);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    @GetMapping("/enterprise/deleteById/{id}")
    public Result deleteById(@PathVariable String id){
        enterpriseService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    @GetMapping("/enterprise/search/hotlist")
    public Result hotlist(){
        return new Result(true,StatusCode.OK,"查询成功",enterpriseService.hotlist());
    }

}
