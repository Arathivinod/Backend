public class Employee {
    private String name;
    private String joiningDate;
    private int sickLeavesTaken;

    // Constructor
    public Employee(String name, String joiningDate, int sickLeavesTaken) {
        this.name = name;
        this.joiningDate = joiningDate;
        this.sickLeavesTaken = sickLeavesTaken;
    }

    // Getters and setters
    public String getName() {

        return name;
    }

    public String getJoiningDate() {
             // Call grantBonus on each individual employee
        return joiningDate;
    }

    public int getSickLeavesTaken() {

        return sickLeavesTaken;
    }

    public void setSickLeavesTaken(int sickLeavesTaken) {

        this.sickLeavesTaken = sickLeavesTaken;
    }


    public void grantBonus() {
        if (sickLeavesTaken < 2) {
            System.out.println(name + " is eligible for a bonus!");
        } else {
            System.out.println(name + " does not qualify for a bonus.");
        }
    }
}
