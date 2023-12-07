package com.springbootdb.mysqlalone.service.impl;

import com.springbootdb.mysqlalone.entity.Dept;
import com.springbootdb.mysqlalone.mapper.test1.DeptMapper;
import com.springbootdb.mysqlalone.service.DeptServiceHost;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("deptService")
public class DeptServiceHostImpl implements DeptServiceHost {

    @Resource
    private DeptMapper deptMapperone;


    @Override
    public List<Dept> queryDept() {
        return deptMapperone.queryDept();
    }
}
