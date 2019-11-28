package springapp.spittr.config.dataconfig;


import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "springapp.spittr.data")
public class DataConfig {



    @Bean
    public DataSource dataSource(Environment e){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(e.getProperty("spittr.url"));
        dataSource.setDriverClassName(e.getProperty("driver"));
        dataSource.setUsername(e.getProperty("spitter.username"));
        dataSource.setPassword(e.getProperty("spitter.password"));
        return dataSource;
    }

 /*   @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
*/


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(ds);
        entityManagerFactoryBean.setJpaVendorAdapter(hibernateAdapter());
        entityManagerFactoryBean.setPackagesToScan("springapp.spittr.domain");
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        entityManagerFactoryBean.setJpaProperties(properties);
        return entityManagerFactoryBean;
    }


    private HibernateJpaVendorAdapter hibernateAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
        return adapter;
    }





}
