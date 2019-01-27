/* Filename: ProjectOne.java
 * Author: Zachary Brandenburg
 * Date: 23 January 2019
 * Purpose:
 */
package projectone;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProjectOne {

    static double totalEmployeeSalary(ArrayList<Employee> employeeArrayList) {
        double totalSalary = 0;
        for (Employee employee : employeeArrayList) {
            totalSalary += employee.annualSalary();
        }

        return totalSalary;
    }

    public static void main(String[] args) {

        final int WORK_YEAR = 0;
        String fileName = "employeeData.txt";
        String tempString;
        ArrayList<Employee> employeeData2014 = new ArrayList<>();
        ArrayList<Employee> employeeData2015 = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((tempString = bufferedReader.readLine()) != null) {
                String[] tempStringArray = tempString.split(" ");

                CreateEmployeeObject thisEmployee;

                switch (tempStringArray[WORK_YEAR]) {
                    case "2014":
                        thisEmployee = new CreateEmployeeObject(tempStringArray);
                        employeeData2014.add(thisEmployee.makeEmployee());
                        break;
                    case "2015":
                        thisEmployee = new CreateEmployeeObject(tempStringArray);
                        employeeData2015.add(thisEmployee.makeEmployee());
                        break;
                }
            }

            // Close file
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file: " + fileName);
        } catch (IOException ex) {
            System.out.println("Error readinr file: " + fileName);
        }

        System.out.println("\n\n------- Employee Data for 2014 -------");
        System.out.println("\tTotal Salary: "
                + Employee.formatter.format(totalEmployeeSalary(employeeData2014)));
        System.out.println("\tAverage Salary: "
                + Employee.formatter.format(totalEmployeeSalary(employeeData2014)
                        / employeeData2014.size()));
        employeeData2014.forEach((employee) -> {
            employee.display();
        });
        System.out.println("\n\n------- Employee Data for 2015 -------");
        System.out.println("\tTotal Salary: "
                + Employee.formatter.format(totalEmployeeSalary(employeeData2015)));
        System.out.println("\tAverage Salary: "
                + Employee.formatter.format(totalEmployeeSalary(employeeData2015)
                        / employeeData2015.size()));
        employeeData2015.forEach((employee) -> {
            employee.display();
        });

    }
}
