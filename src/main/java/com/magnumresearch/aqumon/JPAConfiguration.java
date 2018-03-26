//package com.magnumresearch.aqumon;
//
//import oracle.jdbc.pool.OracleDataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.Database;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//import java.sql.SQLException;
//
//@Configuration
//@EnableJpaRepositories(basePackages = "com.boostrdev.weblogic.legacy",
//        entityManagerFactoryRef = "entityManagerFactory",
//        transactionManagerRef = "transactionManager"
//)
//public class JPAConfiguration {
//    @Bean
//    public DataSource createDataSource() throws SQLException {
//        OracleDataSource dataSource = null;
//        dataSource = new OracleDataSource();
//
//        dataSource.setURL("jdbc:oracle:thin:@10.241.95.135:1528:RBAD_DB");
//        dataSource.setUser("rbaddb_user");
//        dataSource.setPassword("123456");
//        dataSource.setImplicitCachingEnabled(true);
//        dataSource.setFastConnectionFailoverEnabled(true);
//        return dataSource;
//    }
//
//    @Bean
//    public HibernateJpaVendorAdapter jpaVendorAdapterOracle() {
//        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//        adapter.setDatabase(Database.ORACLE);
//        adapter.setShowSql(true);
//        adapter.setGenerateDdl(false);
//        return adapter;
//    }
//
//    /*
//     * 配置EntityManager
//     */
//    @Bean(name = "entityManagerFactory")
//    public EntityManagerFactory createEntityManager(DataSource dataSource) {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource); //配置数据源
//
//        em.setPersistenceUnitName("myPersistence1");
//        em.setJpaVendorAdapter(jpaVendorAdapterOracle());
//
//        em.setPackagesToScan("com.boostrdev.weblogic.legacy");//设置实体类的扫描路径
//        em.afterPropertiesSet();
//        return em.getObject();
//    }
//
//    /*
//     * 定义一个事务
//     */
//    @Bean(name = "transactionManager")
//    public PlatformTransactionManager createPlatformTransactionManager(EntityManagerFactory emf) {
//        JpaTransactionManager tm = new JpaTransactionManager();
//        tm.setEntityManagerFactory(emf);
//        return tm;
//    }
//
//}
