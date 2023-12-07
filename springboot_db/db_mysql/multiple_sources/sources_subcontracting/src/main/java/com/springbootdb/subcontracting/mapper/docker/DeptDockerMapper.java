package com.springbootdb.subcontracting.mapper.docker;

import com.springbootdb.subcontracting.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDockerMapper {

    public List<Dept> queryDeptDocker();
}
