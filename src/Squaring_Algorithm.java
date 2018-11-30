import java.util.Scanner;

/**
 * @author Weichen Wang
 * @date 2018/11/20 - 2:44 PM
 * @description: ${description}
 */
public class Squaring_Algorithm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter x and n :");
        int x = sc.nextInt();
        int n = sc.nextInt();
        expBySquaring(x, n);
        System.out.println("\nResult: " + expBySquaring(x,n));
    }

    public static int expBySquaring(int x, int n) {
        if (n < 0) {
            return expBySquaring(1 / x, -n);
        } else if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n % 2 == 0) {
            return expBySquaring(x * x, n / 2);
        } else {
            return x * expBySquaring(x * x, (n - 1) / 2);
        }
    }


}
