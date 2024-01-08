import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MyJDBC {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/sys";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Welcome@123";

    public static void main(String[] args) {
        try {
            readData();

            // Create operation
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter first name:");
            String firstName = scanner.nextLine();
            System.out.println("Enter last name:");
            String lastName = scanner.nextLine();
            System.out.println("Enter designation:");
            String designation = scanner.nextLine();
            createData(firstName, lastName, designation);

            // Read operation after create
            readData();

            // Update operation
            System.out.println("Enter employee ID to update:");
            int employeeIdToUpdate = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.println("Enter new first name:");
            String newFirstName = scanner.nextLine();
            updateData(employeeIdToUpdate, newFirstName);

            // Read operation after update
            readData();

            // Delete operation
            System.out.println("Enter employee ID to delete:");
            int employeeIdToDelete = scanner.nextInt();
            deleteData(employeeIdToDelete);

            // Read operation after delete
            readData();

            // Close the scanner
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read operation
    public static void readData() throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM employees")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getString("first_name") + " " +
                        resultSet.getString("second_name") + " " +
                        resultSet.getString("designation"));
            }
        }
    }

    // Create operation
    public static void createData(String firstName, String lastName, String designation) throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO employees (first_name, second_name, designation) VALUES (?, ?, ?)")) {

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, designation);

            preparedStatement.executeUpdate();
        }
    }

    // Update operation
    public static void updateData(int employeeId, String newFirstName) throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE employees SET first_name = ? WHERE emp_id = ?")) {

            preparedStatement.setString(1, newFirstName);
            preparedStatement.setInt(2, employeeId);

            preparedStatement.executeUpdate();
        }
    }

    // Delete operation
    public static void deleteData(int employeeId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM employees WHERE emp_id = ?")) {

            preparedStatement.setInt(1, employeeId);

            preparedStatement.executeUpdate();
        }
    }
}
