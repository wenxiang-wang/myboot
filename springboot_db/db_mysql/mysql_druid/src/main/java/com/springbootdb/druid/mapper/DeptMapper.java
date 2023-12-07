package com.springbootdb.druid.mapper;

import com.springbootdb.druid.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {

    public List<Dept> queryDept();
}
