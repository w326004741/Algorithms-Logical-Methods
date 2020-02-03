package Exam_Test;

/**
 * @author Weichen Wang
 * @date 2018/12/10 - 11:13 PM
 * @description: ${description}
 */
public class factorial {
    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(factorial1(5));
    }


    // 递归
    public static int factorial(int n) {
        if ((n == 1) || (n == 0)) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static int factorial1(int a) {
        int sum = 1;
        int n = 5;
        for (int i = 1; i <= n; i++) {
            sum = sum * i;
        }
        return sum;
    }


}
