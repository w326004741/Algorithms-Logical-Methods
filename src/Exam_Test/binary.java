package Exam_Test;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * @author Weichen Wang
 * @date 2018/12/11 - 10:08 AM
 * @description: ${description}
 */
public class binary {

//    public static int binary(int x, int[] b) {
//        int i = 0;
//        int j = b.length;  // 数组长度
//        int m = (i + j) / 2; // middle 中间位置
//        //
//        while (i < j) {
//            if (b[m] < x) {
//                i = m + 1;
//            } else if (b[m] >= x) {
//                j = m;
//            }
//            m = (i + j) / 2; // re-set the m
//        }
//        return m;
//    }

    public static int binary2(int x, int[] array) {
        int left = 0;
        int right = array.length;
        int mid = (left + right) / 2;

        while (left < right) {

            if (array[mid] > x) { // x在左边
                right = mid - 1;
            } else if (array[mid] < x) { // x 在右边
                left = mid + 1;
            } else {
                right = mid;
            }
            mid = (left + right) / 2; // re-set mid
        }
        return mid;
    }


    public static void main(String[] args) {
        int[] b = {1, 3, 5, 7, 9, 11, 12, 13, 14, 16, 17, 18, 21, 22};
        System.out.println(binary2(22, b));
    }
}
