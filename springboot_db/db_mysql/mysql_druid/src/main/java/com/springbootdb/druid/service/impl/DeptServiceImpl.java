package com.springbootdb.druid.service.impl;

import com.springbootdb.druid.entity.Dept;
import com.springbootdb.druid.mapper.DeptMapper;
import com.springbootdb.druid.service.DeptService;
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
