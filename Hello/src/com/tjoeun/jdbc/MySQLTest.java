package com.tjoeun.jdbc;
import java.sql.*;

public class MySQLTest 
{
   public static void main(String[] args) 
   {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      System.out.println("Connecting to database...");
	      
	      String url = "jdbc:mysql://localhost:3306/world?characterEncoding=UTF-8&serverTimezone=UTC&SSL=false";
	      conn = DriverManager.getConnection(url, "root", "tjoeun");
	
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      
	      String sql = "SELECT * FROM country WHERE code='KOR'";
	      ResultSet rs = stmt.executeQuery(sql);
	      
	      while(rs.next()){
	         //Retrieve by column name
	         String name  = rs.getString("name");
	         String continent = rs.getString("continent");
	         String capital = rs.getString("capital");
	
	         //Display values
	         System.out.print(name);
	         System.out.print("\t" + continent);
	         System.out.print("\t" + capital);
	      }
	
	      rs.close();
	      stmt.close();
	      conn.close();
	   }catch(SQLException se){
	      se.printStackTrace();
	   }catch(Exception e){
	      e.printStackTrace();
	   }finally{
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
	      }//end of catch
	      System.out.println("\nGoodbye!");
	   }//end finally
   }//end of main()
}
