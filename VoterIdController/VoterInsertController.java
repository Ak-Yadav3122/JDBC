package VoterIdController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;



public class VoterInsertController {

	public static void main(String[] args) {
		// Step:1 Load/REGISTER the driver
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
			 // step:2 Create the  connection
			 
			 String url = "jdbc:mysql://localhost:3306/sys";
			 String userName = "root";
			 String password = "22Aichchhik@31";
			 
			 Connection connection = DriverManager.getConnection(url, userName, password);
			 
			 // step:3 create statement
			 Statement statement = connection.createStatement();
			   
			 // Step:4 Execute Query
			 
			 String inserQuery = "insert into Voterid(Id,Name,DOB,Address,FatherName,Gender) value(231,'Aichchhik', '2002-07-02','Delta-2','Mr.Mrityunjay','Male')";
			
			 statement.execute(inserQuery);
			 
			 System.out.println("Data Stored");
			 
		 }
		 catch(Exception e) {
			 e.printStackTrace();
			 System.out.println("Data is not stored");
		 }
	}   
}
