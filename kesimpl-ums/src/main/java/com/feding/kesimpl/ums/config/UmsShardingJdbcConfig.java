package com.feding.kesimpl.ums.config;

import com.feding.kesimpl.constant.GlobalConst;
import io.shardingjdbc.core.api.MasterSlaveDataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

@Configuration
public class UmsShardingJdbcConfig {
    private static final Logger log = LoggerFactory.getLogger(UmsShardingJdbcConfig.class);
    @Bean
    public DataSource dataSource(){
        DataSource dataSource =null;
        try {
             dataSource = MasterSlaveDataSourceFactory.createDataSource(ResourceUtils.getFile(GlobalConst.CLASSPATH_PREFIX + GlobalConst.JDBC_FILE));
        } catch (SQLException e) {
            log.error("数据源创建失败=[{}]",e.getMessage());
        } catch (IOException e) {
            log.error("jdbc配置文件加载失败=[{}]",e.getMessage());
        }
        return dataSource;
    }

}
