package com.ajcs.data.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.ajcs.data.repository.refdata",
        entityManagerFactoryRef = "entityManagerFactoryRefdata",
        transactionManagerRef = "transactionManagerRefdata"
)
public class DatabaseConfigRefData {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.refdata")
    public DataSourceProperties refdataDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "refdataDataSource")
    public DataSource dataSourceTrade() {
        return refdataDataSourceProperties().initializeDataSourceBuilder().build();
    }


    @Bean(name ="entityManagerFactoryRefdata")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryRefdata(
            EntityManagerFactoryBuilder builder,
            @Qualifier("refdataDataSource") DataSource dataSource) {

        return builder.dataSource(dataSource)
                .packages("com.ajcs.data.model.refdata")
                .persistenceUnit("refdata")
                .build();
    }

    @Bean
    public PlatformTransactionManager transactionManagerRefdata(
            @Qualifier("entityManagerFactoryRefdata")
            EntityManagerFactory tradeEntityManagerFactory) {
        return new JpaTransactionManager(tradeEntityManagerFactory);
    }

}
