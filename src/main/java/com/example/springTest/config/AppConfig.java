/**
 *
 */
/**
 * @author super
 *
 */
package com.example.springTest.config;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.seasar.doma.SingletonConfig;
import org.seasar.doma.jdbc.Config;
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
        try {
            dialect = new PostgresDialect();
            DataSource dataSource = (DataSource) InitialContext.doLookup("java:jboss/jdbc/MADS");
            localTransactionDataSource = new LocalTransactionDataSource(dataSource);
            transactionManager = new LocalTransactionManager(
                    localTransactionDataSource.getLocalTransaction(getJdbcLogger()));
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
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
