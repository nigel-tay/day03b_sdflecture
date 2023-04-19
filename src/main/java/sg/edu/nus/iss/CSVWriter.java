package sg.edu.nus.iss;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVWriter {

    // We can call static final variable via dot notation
    public static final String COMMA_DELIMETER = ",";
    public static final String NEWLINE_SEPARATOR = "\n";
    public static final String FILE_HEADER = "staffNo,fullName,department,role,emailAddress,salary";

    public List<Employee> employees = null;

    public List<Employee> generateEmployees() {
        employees = new ArrayList<>();

        Employee emp1 = new Employee("1234", "bryan", "CRM", "HR", "bryan@visa.com", 10000);
        Employee emp2 = new Employee("1235", "john", "CRM", "HR", "john@visa.com", 10000);
        Employee emp3 = new Employee("1236", "sam", "CRM", "HR", "bryan@visa.com", 10000);
        
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        return employees;
    }

    public void writeToCSV(List<Employee> employees, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);

        // Write FILE_HEADER into specified file
        BufferedWriter bw = new BufferedWriter(fileWriter);
        bw.append(FILE_HEADER + "\n"); // Appends eadch individual character in the string
        
        // Iterate through employees to write each employee record to file
        for (Employee individuaEmployee: employees) {
            bw.append(individuaEmployee.getStaffNo());
            bw.append(COMMA_DELIMETER);
            bw.append(individuaEmployee.getFullName());
            bw.append(COMMA_DELIMETER);
            bw.append(individuaEmployee.getDepartment());
            bw.append(COMMA_DELIMETER);
            bw.append(individuaEmployee.getRole());
            bw.append(COMMA_DELIMETER);
            bw.append(individuaEmployee.getEmailAddress());
            bw.append(COMMA_DELIMETER);
            bw.append(String.valueOf(individuaEmployee.getSalary()));
            bw.append(NEWLINE_SEPARATOR);

        }
        // Flush and close fileWriter
        bw.flush();
        bw.close();
        fileWriter.close();
    }
}
