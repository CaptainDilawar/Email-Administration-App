import java.io.FileWriter;
import java.io.IOException;

public class ExcelWriter {
    private static final String FILE_NAME = "employees.csv";

    public static void saveEmployeesToCSV(Employee[] employees) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            // Write header row
            writer.append("Name,Email,Department");
            writer.append("\n");

            // Write data rows
            for (Employee employee : employees) {
                writer.append(employee.getFirstName());
                writer.append(",");
                writer.append(employee.getEmail());
                writer.append(",");
                writer.append(employee.getDepartment());
                writer.append("\n");
            }

            System.out.println("Employees' records saved to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error occurred while saving employees' records to CSV: " + e.getMessage());
        }
    }
}