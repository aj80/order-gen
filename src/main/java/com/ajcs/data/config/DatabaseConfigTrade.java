package com.ajcs.data.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
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
        basePackages = "com.ajcs.data.repository.trade",
        entityManagerFactoryRef = "entityManagerFactoryTrade",
        transactionManagerRef = "transactionManagerTrade"
)
public class DatabaseConfigTrade {

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.trade")
    public DataSourceProperties primaryDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "tradeDataSource")
    public DataSource dataSourceTrade() {
        return primaryDataSourceProperties().initializeDataSourceBuilder().build();
    }


    @Primary
    @Bean(name ="entityManagerFactoryTrade")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryTrade(
            EntityManagerFactoryBuilder builder,
            @Qualifier("tradeDataSource") DataSource dataSource) {

        return builder.dataSource(dataSource)
                .packages("com.ajcs.data.model.trade")
                .persistenceUnit("trade")
                .build();
    }

    @Bean
    public PlatformTransactionManager transactionManagerTrade(
            @Qualifier("entityManagerFactoryTrade")
            EntityManagerFactory tradeEntityManagerFactory) {
        return new JpaTransactionManager(tradeEntityManagerFactory);
    }

}
