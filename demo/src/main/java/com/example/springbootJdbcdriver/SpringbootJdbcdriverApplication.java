package com.example.springbootJdbcdriver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class SpringbootJdbcdriverApplication {
	private final String url = "jdbc:postgresql://rtp-timescaledb-replica.prd.us-east-1.ttmzero.com:5432/rtp";
	private final String user = "analysis_user";
	private final String password = "sKFGZPrHuDsJpYKOYXZooc47WQqtt6B717AWOaXwPk6";

	public Connection connect() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);
			System.out.println("Connected to the PostgreSQL server successfully.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return conn;
	}
	public static void main(String[] args) throws SQLException {
		SpringApplication.run(SpringbootJdbcdriverApplication.class, args);
		SpringbootJdbcdriverApplication main = new SpringbootJdbcdriverApplication();
		Statement dbStatement = null;

		if (main.connect() != null) {
			Connection dbConnection = main.connect();
			dbStatement = dbConnection.createStatement();
			System.out.println("Connected to the database!");
		} else {
			System.out.println("Failed to make connection!");
		}
		System.out.println("Preparing for query");
//        System.out.println(dbStatement);
		//TODO:get the value in the resultSet
		ResultSet resultSet = dbStatement.executeQuery("SELECT * FROM indications.historical");
		System.out.println(resultSet);
	}

}
