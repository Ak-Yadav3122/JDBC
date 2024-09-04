package VoterIdController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDataExample {
    public static void main(String[] args) {

        // Database credentials
        String url = "jdbc:mysql://localhost:3306/sys";
        String userName = "root";
        String password = "22Aichchhik@31";
        
        // Connection object
        Connection connection = null;

        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(url, userName, password);

            // Check if ID is three digits long
            String id = "231"; // Replace this with your ID

            if (id.matches("\\d{3}")) {
                
                // SQL query to insert data into the table
                String sql = "insert into Voterid(Id,Name,DOB,Address,FatherName,Gender) value(?,?,?,?,?,?)";

                // Sample values for name, age, and address
                String name = "Aichchhik";
                String DOB = "2002-07-02";
                String address = "Delta-2";
                String FatherName = "Mr.Mrityunjay";
                String Gender = "MALE";

                // Create a PreparedStatement
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, id);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, DOB);
                preparedStatement.setString(4, address);
                preparedStatement.setString(5, FatherName);
                preparedStatement.setString(6, Gender);

                // Execute the query
                int rowsAffected = preparedStatement.executeUpdate();

                // Display the result
                System.out.println(rowsAffected + " row(s) affected And Data Stored.");
            } else {
                System.out.println("You can not store Id more then 3 ");
            }

        } catch (SQLException e) {
            // Handle errors for JDBC
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // Finally block to close resources
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
