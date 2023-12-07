package com.springbootdb.mysqlalone.service.impl;

import com.springbootdb.mysqlalone.entity.Dept;
import com.springbootdb.mysqlalone.mapper.DeptMapper;
import com.springbootdb.mysqlalone.service.DeptService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("deptService")
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptMapper deptMapper;

    @Override
    public List<Dept> queryDept() {
        return deptMapper.queryDept();
    }
}
