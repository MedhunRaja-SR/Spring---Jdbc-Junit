package cts.springBoot1JDBC.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JdbcCongif {
	
	@Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource= new DriverManagerDataSource();
        dataSource.setDriverClassName(
                "com.mysql.jdbc.Driver");
            dataSource.setUrl(
                "jdbc:mysql://localhost:3306/test");
            dataSource.setUsername("root");
            dataSource.setPassword("root");

        return dataSource;
    }

}
