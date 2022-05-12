package com.example.testsammen;

import java.sql.*;

public class Database {

    private Connection connection; //make final
    private Statement stmt;
    private final String databaseName = "Electric-Control.db";
    private String url = "scenic-theorem-349816:europe-west3:electric-control";

    Database() {
        connection = null; //move to final and add throws clause to database constructor
        stmt = null;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //prepared SQL-exequteUpdate
    public void DbsqlUpdate(String SQLUpdate) {
        try {
            Statement sta = connection.createStatement();
            sta.executeUpdate(SQLUpdate);
            sta.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //prepared SQL-exequteUpdate with print
    public void DbsqlUpdateAndPrint(String SQLUpdate, String print) {
        try {
            Statement sta = connection.createStatement();
            sta.executeUpdate(SQLUpdate);
            sta.close();
            System.out.println(print);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //prepared SQL-query todo skal måske slettes
    public void DbsqlQuery(String sql) {
        try {
            connection = DriverManager.getConnection(url);
            PreparedStatement prep = connection.prepareStatement(sql);
            try (ResultSet res = prep.executeQuery()) {
                while (res.next()) {
                    System.out.println(res.getString(1));
                }
            }
        } catch (SQLException e) {
            e.getErrorCode();
        }
    }
}