package com.feding.kesimpl.sms.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.feding.kesimpl.constant.GlobalConst;
import io.shardingjdbc.core.api.MasterSlaveDataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

@Component
public class ShardingJdbcConfig {
    private static final Logger log = LoggerFactory.getLogger(ShardingJdbcConfig.class);

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = null;
        try {
            dataSource = MasterSlaveDataSourceFactory.createDataSource(ResourceUtils.getFile(GlobalConst.CLASSPATH_PREFIX + GlobalConst.JDBC_FILE));
        } catch (SQLException e) {
            log.error("数据源初始化失败：{}", e.getMessage());
        } catch (IOException e) {
            log.error("配置文件加载失败：{}", e.getMessage());
        }
        return dataSource;
    }

    /**
     * mybatis-plus 分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
