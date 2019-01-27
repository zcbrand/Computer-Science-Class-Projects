/* Filename: ProjectOne.java
 * Author: Zachary Brandenburg
 * Date: 23 January 2019
 * Purpose: A program that reads in employee data from a text file, Employee 
 * objects of the appropriate type are created and are stored in one of two 
 * arrays depending upon the year. Once all the employee data is read in, a 
 * report will be displayed on the console for each of the two years. For each 
 * of the two years, an average of all salaries for all employees for that year 
 * should be computed and displayed.
 */
package projectone;

import java.io.*;
import java.util.ArrayList;

public class ProjectOne {

    // Method for calculating a years total salary
    public static double totalEmployeeSalary(ArrayList<Employee> employeeArrayList) {
        double totalSalary = 0;
        for (Employee employee : employeeArrayList) {
            totalSalary += employee.annualSalary();
        }
        return totalSalary;
    }

    // Method which prints out a years employee data
    public static void displayEmployeeData(int year, ArrayList<Employee> employeeArrayList) {
        // Calculate total employee salary for the year
        double totalSalary = totalEmployeeSalary(employeeArrayList);

        System.out.println("\n\n------- Employee Data for " + year + " -------");
        System.out.println("\tTotal Salary: "
                + Employee.formatter.format(totalSalary));
        System.out.println("\tAverage Salary: "
                + Employee.formatter.format(totalSalary / employeeArrayList.size()));
        // Prints employee info for each employee 
        employeeArrayList.forEach((employee) -> {
            employee.display();
        });
    }

    public static void main(String[] args) {
        
        // Index location for work year in tempStringArray
        final int WORK_YEAR = 0; 
        // Declare instance variables
        String fileName = "employeeData.txt";
        String tempString;
        ArrayList<Employee> employeeData2014 = new ArrayList<>();
        ArrayList<Employee> employeeData2015 = new ArrayList<>();
        
        // Try-with-resources
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {

            // While statemnet for processing each line of text file
            while ((tempString = bufferedReader.readLine()) != null) {
                // Temporary string array for storing a each
                // split string of tempString
                String[] tempStringArray = tempString.split(" ");

                // Declare Create employee object
                CreateEmployeeObject thisEmployee;

                // Each case creates an appropriate
                switch (tempStringArray[WORK_YEAR]) {
                    case "2014":
                        thisEmployee = new CreateEmployeeObject(tempStringArray);
                        employeeData2014.add(thisEmployee.makeEmployee());
                        break;
                    case "2015":
                        thisEmployee = new CreateEmployeeObject(tempStringArray);
                        employeeData2015.add(thisEmployee.makeEmployee());
                        break;
                    default:
                        System.out.println("Invalid Input");
                } // end switch
            } // end while
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file: " + fileName);
        } catch (IOException ex) {
            System.out.println("Error readinr file: " + fileName);
        } // end try catch

        // Display employee data for all years 
        displayEmployeeData(2014, employeeData2014);
        displayEmployeeData(2015, employeeData2015);
    } // end main
} // end ProjectOne.java
