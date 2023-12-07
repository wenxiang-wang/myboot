package com.springbootdb.subcontracting.mapper;

import com.springbootdb.subcontracting.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {

    public List<Dept> queryDept();
}
