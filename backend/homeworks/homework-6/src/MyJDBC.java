import java.sql.*;
import java.util.Scanner;

public class MyJDBC {

    public static void main(String[] args)
    {

        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the country code: ");
        int code = sc.nextInt();
        try {
            Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/database1", "root", "toor");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select name,capital from Country_details where Country_code= "  +code  );

            while (resultSet.next())
            {
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("capital"));
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
