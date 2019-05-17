/* Name: Fraction.java
 * Author: Zachary Brandenburg
 * Date: 28-April-2019
 * Purpose: Defines a Fraction class
 */

package project4;

public class Fraction implements Comparable<Fraction> {

    private Integer numerator;
    private Integer denominator;
    private String value;

    public Fraction(String fraction) {
        String[] splitString = fraction.split("/");
        value = fraction;
        numerator = Integer.parseInt(splitString[0]);
        denominator = Integer.parseInt(splitString[1]);
    }

    public Integer getNumerator() {
        return numerator;
    }

    public Integer getDenominator() {
        return denominator;
    }

    @Override
    public int compareTo(Fraction other) {
        int val1 = numerator * other.getDenominator();
        int val2 = denominator * other.getNumerator();
        return val1 - val2;
    }

    public String toString() {
        return value;
    }
}
