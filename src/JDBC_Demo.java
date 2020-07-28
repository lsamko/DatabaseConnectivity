import java.sql.*;

public class JDBC_Demo {
    public static void main(String[] args) {

     String url ="jdbc:mysql://127.0.0.1:3306/employees_database";

        try {
            //Establish connection Object
            Connection conn = DriverManager.getConnection(url, "root", "my_password");

            //Create a statement object to send to the database
            Statement statement = conn.createStatement();

           ResultSet resultSet = statement.executeQuery("select * from employees_tbl");

           //insert new data
           statement.executeUpdate("insert into employees_tbl(id, name, dept, salary"
                                                            + "values(800, 'Juliet', 'HR', 5500);");
            //delete 1 row
            statement.executeUpdate("delete from employees_tbl where id=800;");

            //update 1 row
            statement.executeUpdate("update employees_tbl set salary = 7600 where id=700;");

            //Process the result
            int salaryTotal =0;
            while (resultSet.next()){
                System.out.println(resultSet.getString("name"));
                salaryTotal = salaryTotal + resultSet.getInt("salary");
            }
            System.out.println(salaryTotal);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
