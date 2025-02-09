package hello.jdbc.connection;

import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Slf4j
public class ConnectionTest {
    @Test
    void driverManager() throws SQLException {
        Connection con1 = DriverManager.getConnection(ConnectionConst.URL, ConnectionConst.USERNAME,
                ConnectionConst.PASSWORD);
        Connection con2 = DriverManager.getConnection(ConnectionConst.URL, ConnectionConst.USERNAME,
                ConnectionConst.PASSWORD);
        log.info("connection = {} , class = {} ", con1, con1.getClass());
        log.info("connection = {} , class = {} ", con2, con2.getClass());
    }

    @Test
    void dataSourceDriverManager() throws SQLException {
        DataSource dataSource = new DriverManagerDataSource(ConnectionConst.URL,
                ConnectionConst.USERNAME, ConnectionConst.PASSWORD);
        useDataSource(dataSource);
    }

    @Test
    void dataSourceConnectionPool() throws SQLException, InterruptedException {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(ConnectionConst.URL);
        dataSource.setUsername(ConnectionConst.USERNAME);
        dataSource.setPassword(ConnectionConst.PASSWORD);
        dataSource.setMaximumPoolSize(10);
        dataSource.setPoolName("MyPool");

        useDataSource(dataSource);
        Thread.sleep(1000);
    }

    private void useDataSource(DataSource dataSource) throws SQLException {
        Connection con1 = dataSource.getConnection();
        Connection con2 = dataSource.getConnection();
        Connection con3 = dataSource.getConnection();
        Connection con4 = dataSource.getConnection();
        Connection con5 = dataSource.getConnection();
        Connection con6 = dataSource.getConnection();
        Connection con7 = dataSource.getConnection();
        Connection con8 = dataSource.getConnection();
        Connection con9 = dataSource.getConnection();
        Connection con10 = dataSource.getConnection();
        Connection con11 = dataSource.getConnection();


        log.info("connection = {} , class = {} ", con1, con1.getClass());
        log.info("connection = {} , class = {} ", con2, con2.getClass());
    }
}
