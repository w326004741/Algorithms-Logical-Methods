package Exam_Test;

/**
 * @author Weichen Wang
 * @date 2018/12/11 - 2:49 PM
 * @description: ${description}
 */
public class prime {

    public static void main(String[] args) {
        System.out.println(prime(15, 3));
    }

    public static int prime(int x, int i) {
        if (i == 0) {
            return 1;
        }
        if (x % i == 0) {
            return 0;
        } else {
            return prime(x, i - 1);
        }

    }
}
