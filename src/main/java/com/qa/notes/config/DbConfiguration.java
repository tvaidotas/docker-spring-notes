package com.qa.notes.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.aws.jdbc.config.annotation.EnableRdsInstance;
import org.springframework.cloud.aws.jdbc.config.annotation.RdsInstanceConfigurer;
import org.springframework.cloud.aws.jdbc.datasource.DataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = { "qcom.qa.notes" })
@EnableJpaRepositories(basePackages = { "com.qa.notes" })
@EnableRdsInstance(dbInstanceIdentifier = "database-1", username = "example2", password = "", databaseName = "test")
public class DbConfiguration {

    @Value("${cloud.aws.region}")
    private String region;

    @Bean
    public RdsInstanceConfigurer instanceConfigurer() {

        return new RdsInstanceConfigurer() {
            @Override
            public DataSourceFactory getDataSourceFactory() {
                IamTomcatJdbcDataSourceFactory dataSourceFactory = new IamTomcatJdbcDataSourceFactory();
                dataSourceFactory.setRegion(region);

                return dataSourceFactory;
            }
        };
    }
}