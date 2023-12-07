package com.springbootdb.druid.controller;

import com.springbootconnector.interfacewrapper.ResponseResult;
import com.springbootdb.druid.entity.Dept;
import com.springbootdb.druid.service.DeptService;
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
        return ResponseResult.success(deptService.queryDept());
    }
}
