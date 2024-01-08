import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Set<Employee> employees = new HashSet<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Do you want to enter details for a new employee? (yes/no): ");
            String response = sc.nextLine().toLowerCase();

            if (!response.equals("yes")) {
                break; // Exit the loop if the user enters anything other than "yes"
            }

            System.out.println("Enter details for a new employee:");
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Hire Date (YYYY-MM-DD): ");
            String hireDate = sc.nextLine();

            System.out.print("Sick leave no: ");
            int sickLeave = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            Employee employee = new Employee(name, hireDate, sickLeave);
            employees.add(employee);
        }

        Iterator<Employee> itr = employees.iterator();
        while (itr.hasNext()) {
            Employee employee = itr.next();
            employee.grantBonus();
        }
    }
}
