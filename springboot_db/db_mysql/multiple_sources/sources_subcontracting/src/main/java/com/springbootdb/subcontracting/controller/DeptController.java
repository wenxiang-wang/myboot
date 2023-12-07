package com.springbootdb.subcontracting.controller;

import com.springbootconnector.interfacewrapper.ResponseResult;
import com.springbootdb.subcontracting.entity.Dept;
import com.springbootdb.subcontracting.service.DeptDockerService;
import com.springbootdb.subcontracting.service.DeptHostService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Resource
    private DeptHostService deptHostService;

    @Resource
    private DeptDockerService deptDockerService;

    @RequestMapping("queryHost")
    public ResponseResult<List<Dept>> queryDeptHost() {
        return ResponseResult.success(deptHostService.queryDeptHost());
    }

    @RequestMapping("queryDocker")
    public ResponseResult<List<Dept>> queryDeptDocker() {
        return ResponseResult.success(deptDockerService.queryDeptDocker());
    }
}
