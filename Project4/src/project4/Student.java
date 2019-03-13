/* Filename: Student.java
 * Author: Zachary Brandenburg
 * Date: 10 March 2019
 * Purpose: contains variables for the student name, major, and
 * credit hours and quality points that are used to compute the GPA
 */
package project4;

public class Student {

    private String studentName;
    private String studentMajor;
    private int creditHours;
    private double qualityPoints;
    private double GPA = (creditHours > 0) ? (qualityPoints / creditHours) : "4.0";

    /* Constructor that is used when new student records are created. It accepts the name
     *  major as parameters and initializes the fields that are used to compute the GPA to zero.
     */
    public Student(String studentName, String studentMajor) {
        this.studentName = studentName;
        this.studentMajor = studentMajor;
        creditHours = 0;
        qualityPoints = 0;
    }

    /* Accepts the course grade and credit hours and updates the variables used to compute the GPA.
     * It will be called when an Update request is made.
     */
    public void courseCompleted(int creditHours, double qualityPoints) {
        this.creditHours += creditHours;
        this.qualityPoints += qualityPoints * creditHours;
    }


    @Override
    public String toString() {
        return "Student Name : " + studentName
                + "\nMajor: " + studentMajor
                + "\nGPA: " + String.format("%.2f", GPA);
    }
}
