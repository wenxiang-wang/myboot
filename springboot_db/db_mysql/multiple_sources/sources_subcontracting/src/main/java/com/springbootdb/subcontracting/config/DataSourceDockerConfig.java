package com.springbootdb.subcontracting.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.springbootdb.subcontracting.mapper.docker", sqlSessionFactoryRef = "dockerSqlSessionFactory")
public class DataSourceDockerConfig {
    @Bean(name = "dockerDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.docker")
    public DataSource getDateSourceDocker() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dockerSqlSessionFactory")
    public SqlSessionFactory test2SqlSessionFactory(@Qualifier("dockerDataSource") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/mapper/docker/*.xml"));
        return bean.getObject();
    }

    @Bean("dockerSqlSessionTemplate")
    public SqlSessionTemplate test2sqlsessiontemplate(
            @Qualifier("dockerSqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }
}


