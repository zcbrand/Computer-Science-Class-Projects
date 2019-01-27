/* Filename: CreateEmployeeClass.java
 * Author: Zachary Brandenburg
 * Date: 23 January 2019
 * Purpose: A helper class to build out Employee objects of the appropriate type
*/
package projectone;

import static java.lang.Double.parseDouble;

public class CreateEmployeeObject {
    // Declare final variables for array index
    // private final int WORK_YEAR = 0; // Unused
    private final int EMPLOYEE_TYPE = 1;
    private final int EMPLOYEE_NAME = 2;
    private final int EMPLOYEE_MONTHLY_SALARY = 3;
    private final int SALARY_MODIFIER = 4;
    // Declare instance variables
    private Employee newEmployee;
    private String[] stringArray;
    
    // Constructor
    public CreateEmployeeObject(String[] stringArray) {
        this.stringArray = stringArray;
    }
    
    // Class method that creates an Employee object of the appropriate type
    public Employee makeEmployee() {
        switch (stringArray[EMPLOYEE_TYPE].toLowerCase()) {
            case "employee":
                newEmployee = new Employee(stringArray[EMPLOYEE_NAME],
                        parseDouble(stringArray[EMPLOYEE_MONTHLY_SALARY]));
                break;
            case "executive":
                newEmployee = new Executive(stringArray[EMPLOYEE_NAME],
                        parseDouble(stringArray[EMPLOYEE_MONTHLY_SALARY]),
                        parseDouble(stringArray[SALARY_MODIFIER]));
                break;
            case "salesman":
                newEmployee = new Salesman(stringArray[EMPLOYEE_NAME],
                        parseDouble(stringArray[EMPLOYEE_MONTHLY_SALARY]),
                        parseDouble(stringArray[SALARY_MODIFIER]));
                break;
            default:
                System.out.println("Invalid employee type!");
        }
        return newEmployee;
    }
}
