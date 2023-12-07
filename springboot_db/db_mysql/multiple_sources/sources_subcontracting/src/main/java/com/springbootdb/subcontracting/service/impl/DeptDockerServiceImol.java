package com.springbootdb.subcontracting.service.impl;

import com.springbootdb.subcontracting.entity.Dept;
import com.springbootdb.subcontracting.mapper.docker.DeptDockerMapper;
import com.springbootdb.subcontracting.service.DeptDockerService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("deptDockerService")
public class DeptDockerServiceImol implements DeptDockerService {

    @Resource
    private DeptDockerMapper deptDockerMapper;


    @Override
    public List<Dept> queryDeptDocker() {
        return deptDockerMapper.queryDeptDocker();
    }
}
