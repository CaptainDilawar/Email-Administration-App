public class Employee {
    private String firstName;
    private String department;
    private String email;
    private String password;

    public Employee(String firstName, String department, String email, String password) {
        this.firstName = firstName;
        this.department = department;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Name: " + firstName + "\n"
                + "Department: " + department + "\n"
                + "Email: " + email + "\n"
                + "Password: " + password;
    }
}
