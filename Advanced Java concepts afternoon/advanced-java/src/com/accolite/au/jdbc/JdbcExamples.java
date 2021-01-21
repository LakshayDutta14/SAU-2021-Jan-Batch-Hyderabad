package com.accolite.au.jdbc;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.accolite.au.xmlprocessing.XMLProcessingExample;
import com.accolite.au.xmlprocessing.Assignment;
import com.accolite.au.xmlprocessing.Assignments;
public class JdbcExamples {

	
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/advancedjava", "root", "Lakshay14")) {
				
				JdbcExamples jdbcExample =  new JdbcExamples();
				
				storetodb(con,jdbcExample);
				
//				jdbcExample.updateData(con);
//				jdbcExample.readData(con);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	void createTables(Connection con) {
		try (Statement stmt = con.createStatement()) {
			String sql = "create table mydata1(asgmt_id int PRIMARY KEY, name varchar(100), review varchar(100))";
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void insertData(Connection con,Assignments data) throws SQLException {
		
		try {
			List<Assignment> d=data.getAssignment();
			  PreparedStatement prepStmt = con.prepareStatement(    
			    "insert into mydata1(asgmt_id, name, review) values (?,?,?)");
			  for(int i=0;i<d.size();i++)
				{
				  prepStmt.setInt(1,d.get(i).getId());
				  prepStmt.setString(2,d.get(i).getName());
				  prepStmt.setString(3,d.get(i).getReview());
				  prepStmt.addBatch();
					//stmt.execute();
////					stmt.setInt(1, 1);
////					stmt.setString(2, "advanced_java");
////					stmt.setString(3, "yet to begin");
////					stmt.execute();
				}
//				} 
			  int [] numUpdates=prepStmt.executeBatch();
			  for (int i=0; i < numUpdates.length; i++) {
			    if (numUpdates[i] == -2)
			      System.out.println("Execution " + i + 
			        ": unknown number of rows updated");
			    else
			      System.out.println("Execution " + i + 
			        "successful: " + numUpdates[i] + " rows updated");
			  }
			  
			} catch(BatchUpdateException b) {
				b.printStackTrace();
			  // process BatchUpdateException
			} 
		
		
//		String sql = "insert into assignment(asgmt_id, name, review) values(?, ?, ?)";
//		try (PreparedStatement stmt = con.prepareStatement(sql)) {
//			List<Assignment> d=data.getAssignment();
//			for(int i=1;i<=d.size();i++)
//			{
//			stmt.setInt(1,d.get(i).getId());
//			stmt.setString(2,d.get(i).getName());
//			stmt.setString(3,d.get(i).getReview());
//			stmt.addBatch();
//			//stmt.execute();
////			stmt.setInt(1, 1);
////			stmt.setString(2, "advanced_java");
////			stmt.setString(3, "yet to begin");
////			stmt.execute();
//		}
//		}
//		
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

	
	void updateData(Connection con) {
		String sql = "update assignment set review=? where asgmt_id=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, "started");
			stmt.setInt(2, 1);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void readData(Connection con) {
		String sql = "select asgmt_id, name, review from assignment";
		try (Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " +rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void storetodb(Connection con,JdbcExamples jdbcExample) throws SQLException
	 {
		jdbcExample.createTables(con);
		jdbcExample.insertData(con,XMLProcessingExample.jaxBParser());
	 }
}

 
