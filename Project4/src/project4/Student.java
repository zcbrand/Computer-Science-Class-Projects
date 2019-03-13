package sample;

import java.util.Formatter;

public class Student {

    private String studentName;
    private String studentMajor;
    private int creditHours;
    private double qualityPoints;

    public Student(String studentName, String studentMajor) {
        this.studentName = studentName;
        this.studentMajor = studentMajor;
        creditHours = 0;
        qualityPoints = 0;
    }

    public void courseCompleted(int creditHours, double qualityPoints) {
        this.creditHours += creditHours;
        this.qualityPoints += qualityPoints;
    }

    @Override
    public String toString(){
        return "Student Name : " + studentName
                + "\nMajor: " + studentMajor
                + "\nGPA: " + String.format("%.2f", (creditHours * qualityPoints));
    }
}
