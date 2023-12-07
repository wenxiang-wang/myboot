package com.springbootdb.subcontracting.mapper.host;

import com.springbootdb.subcontracting.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptHostMapper {

    public List<Dept> queryDeptHost();
}
