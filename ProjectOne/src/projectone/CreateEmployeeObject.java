/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectone;

import static java.lang.Double.parseDouble;

public class CreateEmployeeObject {

    private final int EMPLOYEE_TYPE = 1;
    private final int EMPLOYEE_NAME = 2;
    private final int EMPLOYEE_MONTHLY_SALARY = 3;
    private final int SALARY_MODIFIER = 4;
    private Employee newEmployee;
    private String[] stringArray;

    public CreateEmployeeObject(String[] stringArray) {
        this.stringArray = stringArray;
    }

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
                newEmployee = new Employee();
                break;
        }
        return newEmployee;
    }
}
