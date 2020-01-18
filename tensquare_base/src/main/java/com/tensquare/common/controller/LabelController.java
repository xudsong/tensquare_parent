package com.tensquare.common.controller;

import com.tensquare.common.entity.Result;
import com.tensquare.common.entity.StatusCode;
import com.tensquare.common.pojo.Label;
import com.tensquare.common.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin //跨域处理
public class LabelController {

    @Autowired
    private LabelService labelService;

    @GetMapping("/label/findAll")
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功", labelService.findAll() );
    }

    @GetMapping("/label/findById/{id}")
    public Result findById(@PathVariable String id){
        return new Result(true,StatusCode.OK, "查询成功", labelService.findById(id));
    }

    @PostMapping("/label/add")
    public Result add(@RequestBody Label label){
        labelService.add(label);
        return new Result(true,StatusCode.OK,"增加成功");
    }

    @PostMapping("/label/update/{id}")
    public Result update(@RequestBody Label label,@PathVariable String id){
        label.setId(id);
        labelService.update(label);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    @GetMapping("/label/deleteById/{id}")
    public Result deleteById(@PathVariable String id){
        labelService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

}
