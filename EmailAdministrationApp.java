import java.util.Scanner;

public class EmailAdministrationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Email Administration App!");

        System.out.print("Enter the number of employees: ");
        int numberOfEmployees = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Employee[] employees = new Employee[numberOfEmployees];

        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.println("\nEmployee #" + (i + 1));
            String firstName = getEmployeeFirstName(scanner);
            String department = getEmployeeDepartment(scanner);
            String email = generateEmail(firstName, department);
            String password = generateRandomPassword();

            employees[i] = new Employee(firstName, department, email, password);
            System.out.println("Employee created:\n" + employees[i]);
        }

        // Save employees' records to an Excel file
        ExcelWriter.saveEmployeesToCSV(employees);

        System.out.println("\nThank you for using the Email Administration App!");
    }

    private static String getEmployeeFirstName(Scanner scanner) {
        System.out.print("Enter the employee's first name: ");
        return scanner.nextLine();
    }

    private static String getEmployeeDepartment(Scanner scanner) {
        while (true) {
            System.out.println("Select the employee's department:");
            System.out.println("1. Web Developer");
            System.out.println("2. App Developer");
            System.out.println("3. System Programmer");
            System.out.println("4. Graphic Designer");
            System.out.print("Enter the department number: ");
            int departmentChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (departmentChoice) {
                case 1:
                    return "Web Developer";
                case 2:
                    return "App Developer";
                case 3:
                    return "System Programmer";
                case 4:
                    return "Graphic Designer";
                default:
                    System.out.println("Invalid department choice. Please try again.");
            }
        }
    }

    private static String generateEmail(String firstName, String department) {
        String departmentShortForm = department.split(" ")[0].toLowerCase();
        return firstName.toLowerCase() + "." + departmentShortForm + "@company.com";
    }

    private static String generateRandomPassword() {
        String validCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+=-";
        int passwordLength = 8;
        StringBuilder passwordBuilder = new StringBuilder();

        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = (int) (Math.random() * validCharacters.length());
            passwordBuilder.append(validCharacters.charAt(randomIndex));
        }

        return passwordBuilder.toString();
    }
}
