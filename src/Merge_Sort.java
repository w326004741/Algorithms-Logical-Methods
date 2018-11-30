
/**
 * @author Weichen Wang
 * @date 2018/11/18 - 11:59 AM
 */
public class Merge_Sort {

    /**
     * perform a merge sort on the data in c. 对c中的数据执行合并排序
     *
     * @param c c != null, all elements of are the same data type.
     */
    public static void mergeSort(Comparable[] c) {
        Comparable[] temp = new Comparable[c.length];
        sort(c, temp, 0, c.length - 1);
    }

    /**
     * 递归算法的实现 把原数组拆分成左，右两边，分别进行排序
     *
     * @param list  array list数组列表
     * @param temp  array of temporary storage 新开辟的临时存放的数组
     * @param left
     * @param right
     */
    private static void sort(Comparable[] list, Comparable[] temp, int left, int right) {
        if (left < right) {
            // 找出中间索引 Find the middle point to divide the array into two halves
            int center = (left + right) / 2;
            // 对左边数组进行递归 recursively on the left array
            sort(list, temp, left, center);
            // 对右边数组进行递归  recursively on the right array
            sort(list, temp, center + 1, right);
            // 合并 merge  merge the two halves sorted
            merge(list, temp, left, center + 1, right);
        }
    }

    /**
     * @param list     array list
     * @param temp     array of temporary storage 新开辟的临时存放的数组
     * @param leftPos  first position index of left 左边的起始位置
     * @param rightPos first position index of right 右边的起始位置
     * @param rightEnd end position index of right 右边的终点位置
     */
    // leftPos = 左边的起始位置，rightPos = 右边的起始位置， rightEnd = 右边的终点位置
    // temp = ç， list = 数组列表
    private static void merge(Comparable[] list, Comparable[] temp, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1; // 左边终点位置。假设左右两列挨着
        int tempPos = leftPos; // 缓存左数组第一个元素的索引
        int numElements = rightEnd - leftPos + 1; // 数组元素个数

        // 实现merge 过程
        // 满足条件: 左边起始位置<= 右边的起始位置-1 && 右边的起始位置 <= 右边的终点位置，循环结束
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            // compareTo() ref: https://blog.csdn.net/u010356768/article/details/71036301
            // 从两个数组中取出最小的放入临时数组
            // compareTo() method: 返回 参与比较的前后两个字符串的asc码差值
            // a.compareTo(b) = return -1, 即 a < b， 切差值为-1
            //这里是比较list[leftPos]，list[rightPos]的ASC码差值是否<=0
            // 即 list[leftPos]，list[rightPos] 谁大谁小
            if (list[leftPos].compareTo(list[rightPos]) <= 0) {
                // 如果 list[leftPos] > list[rightPos]，
                // 则把左边的放入临时缓存的数组temp内并给一个tempPos的索引坐标，确定指定数值位置
                temp[tempPos] = list[leftPos];
                leftPos++; // 并且 左边数据的index继续向右移(读取左边数组下一位数)，即leftPos(index)++
            } else {
                // 否则即 list[leftPos] < list[rightPos]，
                // 则把右边的放入临时缓存的数组temp内并给一个tempPos的索引坐标，确定指定数值位置
                temp[tempPos] = list[rightPos];
                rightPos++; //  并且 右边数据的index继续向右移(读取右边数组下一位数)，即rightPos(index)++
            }
            tempPos++; // 每当有数字存入缓存数组时，缓存数组位置的索引位置就向右移一个，即tempPos的index++
        }
        // copy rest of left half 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
        // 即不满足上面的&&条件的数值 调用这两个while循环去存入缓存数组内
        while (leftPos <= leftEnd) {
            temp[tempPos] = list[leftPos];
            tempPos++;
            leftPos++;
        }
        // copy rest of right half
        while (rightPos <= rightEnd) {
            temp[tempPos] = list[rightPos];
            tempPos++;
            rightPos++;
        }
        // Copy temp back into list 把缓存数组的内容返回存到原list内
        for (int i = 0; i < numElements; i++, rightEnd--) {
            // 倒着返回放入原数组
            list[rightEnd] = temp[rightEnd];
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{4, 9, 11, 8, 67, 3, 4, 2, 32};
        System.out.println("Print Array:");
        print(arr);
        mergeSort(arr);
        System.out.println("Merge Sort：");
        print(arr);
    }

    // traverse Integer data array and output
    public static void print(Integer[] list) {
        for (Integer i : list) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
