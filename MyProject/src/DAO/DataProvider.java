/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author ngoch_000
 */
public class DataProvider {
    String strDatabase="QLSIEUTHI";
    String driverConn="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String connectString="jdbc:sqlserver://localhost:1433;databaseName="+strDatabase;
    Connection connect=null;
    public Connection ConnectDB()
    {
        try {
            Class.forName(driverConn).newInstance();
            connect=DriverManager.getConnection(connectString,"sa","123456");
        } catch (Exception ex)
        {
            throw new Exception(ex.getMessage());
        }
        finally
        {
            return connect;
        }
    }
}
