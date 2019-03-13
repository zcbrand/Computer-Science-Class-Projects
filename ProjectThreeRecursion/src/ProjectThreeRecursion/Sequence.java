/* Filename: Sequence.java
 * Author: Zachary Brandenburg
 * Date: 23 February 2019
 * Purpose: Utility class to perform calculations within the application
 */

package ProjectThreeRecursion;

public class Sequence {
    // Declare variables
    private static int efficiency;

    // Method to compute nth value in an iterative manner
    public static int computeIterative(int n) {

        if (n <= 2) {
            efficiency++;
            return n;
        }

        int a = 1;
        int b = 2;
        int c;

        for (int i = 3; i <= n; i++) {
            c = 2 * b + a;
            a = b;
            b = c;
            efficiency++;
        }

        return b;
    }

    // Method to compute nth value in an recursive manner
    public static int computeRecursive(int n) throws NumberFormatException {

        efficiency++;

        if (n <= 2)
            return n;

        return 2 * computeRecursive(n - 1) + computeRecursive(n - 2);
    }


    public static void resetEfficiency() throws NumberFormatException {
        efficiency = 0;
    }

    public static int getEfficiency() {
        return efficiency;
    }
}
