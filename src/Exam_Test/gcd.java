package Exam_Test;

import java.util.Scanner;

/**
 * @author Weichen Wang
 * @date 2018/12/10 - 9:54 PM
 * @description: ${description}
 */
public class gcd {

    public static void main(String[] args) {

        System.out.println(gcd(10, 45));
    }

    // 递归
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b); // a % b 是求余
        }
    }

    // 非递归
    public static int gcd1(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            while (a % b != 0) {
                int temp = a % b; // 把余数给temp
                a = b; // b -> a
                b = temp; // temp -> b

            }

            return b;

        }
    }
}
