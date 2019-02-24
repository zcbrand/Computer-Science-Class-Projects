package ProjectThreeRecursion;

public class Sequence {
    private static int efficiency;

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

    public static int computeRecursive(int n) {

        efficiency++;

        if (n <= 2)
            return n;

        return 2 * computeRecursive(n - 1) + computeRecursive(n - 2);
    }


    public static void resetEfficiency() {
        efficiency = 0;
    }

    public static int getEfficiency() {
        return efficiency;
    }
}
