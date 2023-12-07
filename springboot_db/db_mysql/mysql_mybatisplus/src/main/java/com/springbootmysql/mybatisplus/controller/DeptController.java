package com.springbootmysql.mybatisplus.controller;

import com.springbootconnector.interfacewrapper.ResponseResult;
import com.springbootmysql.mybatisplus.entity.Dept;
import com.springbootmysql.mybatisplus.service.DeptService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Resource
    private DeptService deptService;

    @RequestMapping("query")
    public ResponseResult<List<Dept>> queryDept() {
        return ResponseResult.success(deptService.list());
    }
}
