package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    
    public List<Employee> readCSV(String fileName) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line = "";
        List<Employee> employees = new ArrayList<Employee>();
        
        // Skip the FILE_HEADER. It has to be assigned
        line = br.readLine();

        // Read each line of CSV record
        // format them into an Employee object
        // Add employee object into list of employees

        while((line = br.readLine()) != null) {
            String[] lineData = line.split(CSVWriter.COMMA_DELIMETER);

            if (lineData.length > 0) {
                Employee emp = new Employee(lineData[0], lineData[1], lineData[2], lineData[3], lineData[4], Integer.parseInt(lineData[5]));
                employees.add(emp);
            }
        }

        // close br
        br.close();

        return employees;
        
    }
}
