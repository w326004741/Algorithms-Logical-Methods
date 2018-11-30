import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Weichen Wang
 * @date 2018/11/20 - 1:06 PM
 * @description: ${description}
 */
public class Fibonacci_Sequence {

    public static void runFibonacci() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a value for fibonacci sequence: ");
        int i = sc.nextInt();
        sc.nextLine();

        for (int x = 0; x < i + 1; x++) {
            System.out.println("Fibonacci using recursion: number " + x + " of fibonacci is -> " + fibonacci(x));
        }
        System.out.println();
    }

    public static void runFibonacci1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a value for fibonacci sequence: ");
        int i = sc.nextInt();
        sc.nextLine();
        for (int x = 0; x < i + 1; x++) {
            System.out.println("Fibonacci without using recursion: number " + x + " of fibonacci is -> " + fibonacci1(x));
        }
        System.out.println();
    }

    /**
     * Fibonacci using recursion.
     *
     * @param position index in fibonacci sequence
     * @return
     */
    public static int fibonacci(int position) {
        // the first two numbers in the Fibonacci sequence are 0 and 1.
        if (position == 0 || position == 1) {
            return position;
        }
        // each subsequent number is the sum of the previous two.
        // F1 = 0, F2 = 1
        // Fn = Fn-1 + Fn-2
        return fibonacci(position - 1) + fibonacci(position - 2);
    }

    /**
     * Fibonacci without using recursion
     * ref: https://www.programiz.com/java-programming/examples/fibonacci-series
     *
     * @param position index in fibonacci sequence
     * @return
     */
    public static int fibonacci1(int position) {
        // the first two numbers in the Fibonacci sequence are 0 and 1.
        if (position == 0 || position == 1) {
            return position;
        }
        // first(x) and second(y) numbers are initialized to first two numbers of the Fibonacci series 0 and 1 respectively.
        int x = 0, y = 1, sum = 0;
        // n-2次循环次数，保证前两位数的值不变 x = 0,y = 1.
        // the loop times = n-2, to hold the first two numbers in the Fibonacci sequence are 0 and 1.
        for (int n = 2; n <= position; n++) {
            sum = x + y; // the sum of previous two numbers stored in variable sum
            x = y;
            y = sum;
        }
        return sum;

    }

    public static void main(String[] args) {
        while (true) {
            menu();
            Scanner sc = new Scanner(System.in);
            int user = sc.nextInt();
            System.out.println();
            switch (user) {
                case 1:
                    runFibonacci();
                    break;
                case 2:
                    runFibonacci1();
                    break;
                case 3:
                    System.out.println("Thank you for your using, See you :)");
                    System.exit(0); // Stop the currently running JVM (memory released)
                    break;
                default:
                    System.out.println("Sorry, We don't have this function, Please Enter Again.");
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("=========================");
        System.out.println("1. Fibonacci using recursion");
        System.out.println("2. Fibonacci without using recursion");
        System.out.println("3. Exit");
        System.out.println("=========================");
        System.out.print("Please enter number : ");
    }
}
