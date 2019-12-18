/**
 * FileName: EntityManageConfig
 * Author:   huang.yj
 * Date:     2019/12/17 19:57
 * Description: EntityManager配置类
 */
package com.sample.test.dao.util;

/**
 * 〈EntityManager配置类〉
 *  springboot一般不需要使用此配置类，只有当需要自定义EntityManager、EntityManagerFactory等，不用springboot默认的配置时才需要此配置类
 * @author huang.yj
 * @create 2019/12/17
 * @since 0.0.1
 */
/*
@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "entityManageFactoryPrimary", transactionManagerRef = "transactionManagerPrimary", basePackages = {
        "com.sample.test.dao" }) // 设置Repository所在位置
public class EntityManageConfig {

    @Autowired
    // @Qualifier("myDataSource") 多数据源的时候可以使用该注解指定
    private HikariDataSource myDataSource;

    @Primary
    @Bean(name = "entityManagerPrimary")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder){
        return entityManageFactory(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "entityManageFactoryPrimary")
    public LocalContainerEntityManagerFactoryBean entityManageFactory(EntityManagerFactoryBuilder builder){
        LocalContainerEntityManagerFactoryBean entityManagerFactory =  builder.dataSource(myDataSource)
                .packages("com.sample.test.common.entity") // 设置实体类所在位置
                // .persistenceUnit("thirdPersistenceUnit")
                .build();
        Properties jpaProperties = new Properties();
        // jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        // jpaProperties.put("hibernate.physical_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy");
        jpaProperties.put("hibernate.connection.charSet", "utf-8");
        jpaProperties.put("hibernate.show_sql", "true");
        entityManagerFactory.setJpaProperties(jpaProperties);
        return entityManagerFactory;
    }

    @Primary
    @Bean(name = "transactionManagerPrimary")
    public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManageFactory(builder).getObject());
    }
}*/