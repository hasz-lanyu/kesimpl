package com.feding.kesimpl.pms.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.feding.kesimpl.constant.GlobalConst;
import io.shardingjdbc.core.api.MasterSlaveDataSourceFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
@Configuration
public class PmsShardingJdbcConfig {
    private static final Logger log = LoggerFactory.getLogger(PmsShardingJdbcConfig.class);
    @Bean
    public DataSource dataSource() {
        DataSource dataSource = null;
        try {
           dataSource= MasterSlaveDataSourceFactory.createDataSource(ResourceUtils.getFile(GlobalConst.CLASSPATH_PREFIX + GlobalConst.JDBC_FILE));
        } catch (SQLException e) {
            log.error("数据源创建失败[{}]",dataSource);
        } catch (IOException e) {
            log.error("jdbc配置文件加载失败=[{}]",PmsShardingJdbcConfig.class);
        }
        return dataSource;
    }

    /**
     * mybatis-plus分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

}
