package com.springbootdb.mysqlalone.service.impl;

import com.springbootdb.mysqlalone.entity.Dept;
import com.springbootdb.mysqlalone.mapper.test2.DeptMapper;
import com.springbootdb.mysqlalone.service.DeptServiceDocker;
import jakarta.annotation.Resource;

import java.util.List;

public class DeptServiceDockerImol implements DeptServiceDocker {

    @Resource
    private DeptMapper deptMapperone;


    @Override
    public List<Dept> queryDept() {
        return deptMapperone.queryDept();
    }
}
