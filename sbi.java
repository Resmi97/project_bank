package jdbc;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class sbi {
   static final String DB_URL = "jdbc:mysql://localhost:3306/";
   static final String USER = "root";
   static final String PASS = "root";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
      ) {		      
         String sql = "create database sbi";
         stmt.executeUpdate(sql);
         System.out.println("Database created successfully...");   	  
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}