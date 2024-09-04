package VoterIdController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VoterIdDisplayController {
        public static void main(String[] args) {

        Connection connection = null;
        // Step:1 Load/REGISTER the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // step:2 Create the connection

            String url = "jdbc:mysql://localhost:3306/sys";
            String userName = "root";
            String password = "22Aichchhik@31";

            connection = DriverManager.getConnection(url, userName, password);

            // step:3 create statement
            Statement statement = connection.createStatement(); // Statement is an interface which are used to execute
                                                                // the querry.

            // Step:4 Execute Query
            String displayProductQuery = "select * from Voterid";

            /*
               For display the data which are used inside the Sql we use ResultSet.
              Resultset is an interface which are used to fetch the data by using getter method row by row or column by column.And it is also move the curser by using next() method.

             */ 
            ResultSet rs = statement.executeQuery(displayProductQuery);
            while (rs.next()) {
                int id = rs.getInt("id");
                System.out.println(id);

                String name = rs.getString("name");
                System.out.println(name);

                String color = rs.getString("color");
                System.out.println(color);

                int price = rs.getInt("price");
                System.out.println(price);

            } // next() it's return type is boolean

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
