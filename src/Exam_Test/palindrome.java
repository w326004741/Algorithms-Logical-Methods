package Exam_Test;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author Weichen Wang
 * @date 2018/12/10 - 11:41 PM
 * @description: ${description}
 */
public class palindrome {

    public static boolean palindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
//        if (x == 0 || x / 10 == 0) return true;
        int n = 0;


        while (x != 0) { // x 一定会等于0
            n = n * 10; // n 先往左移一位
            n = n + x % 10; // n + x % 10
            x = x / 10; // x 少一位
            if (x == n || x / 10 == n) return true;
        }
//        while (x > n) { // x 一定会等于0
//            n = n * 10; // n 先往左移一位
//            n = n + x % 10; // n + x % 10
//            x = x / 10; // x 少一位
//            if (x == n || x / 10 == n) return true;
//        }
//        while (x = n) { // x 一定会等于0
//            n = n * 10; // n 先往左移一位
//            n = n + x % 10; // n + x % 10
//            x = x / 10; // x 少一位
//        }
//        return (x == n || (n / 10 == x));


        return false;
    }

    public static int palindrome1(int n, int temp) {
        if (n == 0)
            return temp;
        else
            temp = (temp * 10) + (n % 10);

        return palindrome1(n / 10, temp);
    }

    public static void main(String[] args) {
//        System.out.println(palindrome(123321));
//        System.out.println(palindrome(12311));

        int n = 123321;
        int temp = palindrome1(n, 0);
        if (temp == n)
            System.out.println("YES");
        else
            System.out.println("NO");
//        System.out.println(palindrome1(123321, 0));
    }
}
