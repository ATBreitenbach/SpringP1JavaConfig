package config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import disburse.dao.JdbcHouseDisburseDAO;

@Configuration
public class HouseDisburseConfig {

	@Bean
	public DataSource ds() throws SQLException {
		DataSource ds = new EmbeddedDatabaseBuilder().addScript("classpath:2013Q4_HOUSE_DISBURSE.sql").build();
		ds.getConnection().setAutoCommit(true);
		return ds;
	}
	
	@Bean
	public DataSource ds2() throws SQLException {
		DataSource ds = new EmbeddedDatabaseBuilder().addScript("classpath:potentialLeads.sql").build();
		ds.getConnection().setAutoCommit(true);
		return ds;
	}
	
	@Bean
	public JdbcHouseDisburseDAO getDao(DataSource ds) throws SQLException {
		JdbcHouseDisburseDAO dao = new JdbcHouseDisburseDAO(ds);
		return dao;
	}
}
