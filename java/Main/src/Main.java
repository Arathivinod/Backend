import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
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
        System.out.print("Enter the name of the employee you want to remove: ");
        String nameToRemove = sc.nextLine();

        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getName().equals(nameToRemove)) {
                iterator.remove(); // Removes the employee with the specified name
                System.out.println(nameToRemove + " has been removed.");
                break; // Exit the loop since the employee is found and removed
            }
    }
}
}
