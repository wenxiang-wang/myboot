package com.springbootdb.mysqlalone.mapper;

import com.springbootdb.mysqlalone.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {

    public List<Dept> queryDept();
}
