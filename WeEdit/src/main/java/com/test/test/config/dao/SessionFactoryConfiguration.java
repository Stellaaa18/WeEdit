package com.test.test.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class SessionFactoryConfiguration {
    //mybatis-config.xml配置文件路径
    @Value("${mybatis_config_file}")
    private String mybatisConfigFilePath;

    //mybatis mapper文件所在路径
    @Value("${mapper_path}")
    private String mapperPath;

    //实体类所在的package
    @Value("${entity_package}")
    private String entityPackage;

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    /**
     * 创建sqlSessionFactoryBean 实例 并且设置configtion 设置mapper 映射路径 设置datasource数据源
     *
     * @return
     * @throws IOException
     */
    @Bean(name="sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //设置mybatis-config的扫描路径
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
        // 添加mapper 扫描路径
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
        // 设置dataSource
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 设置typeAlias 包扫描路径
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
        return sqlSessionFactoryBean;
    }
}
