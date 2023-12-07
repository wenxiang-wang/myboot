package com.springbootmysql.mybatisplus.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootmysql.mybatisplus.entity.Dept;
import com.springbootmysql.mybatisplus.mapper.DeptMapper;
import com.springbootmysql.mybatisplus.service.DeptService;
import org.springframework.stereotype.Service;


@Service("deptService")
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

}
