package ua.knu.montag.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.*;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScan(value = {"ua.knu.montag.spring.dao",
                        "ua.knu.montag.spring.service"})
public class AppConfig {

    private final Environment env;

    public AppConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory(){
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        Properties properties = new Properties();
        properties.put(DRIVER, env.getProperty("postgresql.driver"));
        properties.put(URL, env.getProperty("postgresql.url"));
        properties.put(USER, env.getProperty("postgresql.user"));
        properties.put(PASS, env.getProperty("postgresql.password"));
        properties.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
        properties.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
        properties.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
        properties.put(C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
        properties.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
        properties.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));
        factoryBean.setHibernateProperties(properties);
        factoryBean.setPackagesToScan("ua.knu.montag.spring.model");
        return factoryBean;
    }
    @Bean
    public HibernateTransactionManager getTransactionManager(){
        HibernateTransactionManager transactionManager =new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
}
