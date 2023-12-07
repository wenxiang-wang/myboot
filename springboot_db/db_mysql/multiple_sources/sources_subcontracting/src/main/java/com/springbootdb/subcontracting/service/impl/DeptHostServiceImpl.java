package com.springbootdb.subcontracting.service.impl;

import com.springbootdb.subcontracting.entity.Dept;
import com.springbootdb.subcontracting.mapper.host.DeptHostMapper;
import com.springbootdb.subcontracting.service.DeptHostService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("deptHostService")
public class DeptHostServiceImpl implements DeptHostService {

    @Resource
    private DeptHostMapper deptHostMapper;


    @Override
    public List<Dept> queryDeptHost() {
        return deptHostMapper.queryDeptHost();
    }
}
