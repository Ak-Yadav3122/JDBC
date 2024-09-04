import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateProductController {
	
	public static void main(String[] args) {
		
		Connection connection = null;
		// Step:1 Load/REGISTER the driver
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
			 // step:2 Create the  connection
			 
			 String url = "jdbc:mysql://localhost:3306/sys";
			 String userName = "root";
			 String password = "22Aichchhik@31";
			 
			 connection = DriverManager.getConnection(url, userName, password);
			 
			 // step:3 create statement
			 Statement statement = connection.createStatement();
			   
			 // Step:4 Execute Query
			 String updateProductColorQuery = "update new_table set id = 422 where id=423";
			 
			 //This method will return 0 or 1 when given id is not present in the table
			 
			 int a = statement.executeUpdate(updateProductColorQuery);  // it return the value  i.e; 0 or 1 so we use int 
			 if(a==1) {
				 System.out.println("Data updated");
			 }
			 else {
				 System.out.println("Given primary key is not present in table");
			 }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
			 
		 }finally {
			 try {
			 connection.close();
			 
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
			
		 }
	}
}