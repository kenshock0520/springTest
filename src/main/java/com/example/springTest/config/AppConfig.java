/**
 *
 */
/**
 * @author super
 *
 */
package com.example.springTest.config;

import javax.sql.DataSource;

import org.seasar.doma.SingletonConfig;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.SimpleDataSource;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.PostgresDialect;
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource;
import org.seasar.doma.jdbc.tx.LocalTransactionManager;
import org.seasar.doma.jdbc.tx.TransactionManager;

@SingletonConfig
public class AppConfig implements Config {
    // シングルトンインスタンス
    private static final AppConfig CONFIG = new AppConfig();
    // SQL方言
    private final Dialect dialect;
    // データソース
    private final LocalTransactionDataSource localTransactionDataSource;
    // トランザクション管理を行う
    private final TransactionManager transactionManager;

    private AppConfig() {
        dialect = new PostgresDialect();
//            DataSource dataSource = (DataSource) InitialContext.doLookup("java:jboss/jdbc/MADS");
		SimpleDataSource dataSource = new SimpleDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
		dataSource.setUser("postgres");
		dataSource.setPassword("root");
		localTransactionDataSource = new LocalTransactionDataSource(dataSource);
		transactionManager = new LocalTransactionManager(
		        localTransactionDataSource.getLocalTransaction(getJdbcLogger()));
    }
    @Override
    public Dialect getDialect() {
        return dialect;
    }
    @Override
    public DataSource getDataSource() {
        return localTransactionDataSource;
    }
    @Override
    public TransactionManager getTransactionManager() {
        return transactionManager;
    }
    public static AppConfig singleton() {
        return CONFIG;
    }
}
