/**
 * @author Weichen Wang
 * @date 2018/11/18 - 10:02 PM
 * @description: 1. 以数组的最后一个数据作为参照物（end），
 * 2. 定义左(start)，右(end)两个指针，左指针从数组的第一个数据开始，右指针为参照物的前一个数据(end - 1)
 * 3. 左指针找第一个比它大的，右指针找第一个比它小的
 * 4. 如果左，右指针没有交叉，交换左右指针的位置上的数据（index）
 * 5. 左右指针继续找（左指针找第一个比它大的，右指针找第一个比它小的）
 * 6. 如果左，右指针交叉，交换左指针和参照物的数据
 * 7. 现在 左指针把数组分成2分，即现在无论数据怎么排序，左指针的位置永远不变（左指针的左边都小于左指针，右边的都大于）
 * 8。 然后在左半部分数据中，以最后一个数据作为参照物(end) 继续找
 */
public class Quick_Sort {
    /**
     * @param list  array list 数组列表
     * @param start 起始数据 （从左 第一个）
     * @param end   最后一个数据（参照物）
     */
    public static void quickSort(int list[], int start, int end) {
        // 如果起始输入 >= 最后一个数据，即为同一个数据，则结束排序
        if (start >= end) {
            return;
        } else {
            // 否则至少有两个不同的数据
            int middle = partition(list, start, end); // find partition point 找到分界点
            quickSort(list, start, middle - 1); // quickSort for part of left  左半段
            quickSort(list, middle + 1, end); // quickSort for part of right 右半段
        }
    }

    /**
     * This function takes last element as partition, places
     * * the partition element at its correct position in sorted
     * * array, and places all smaller (smaller than partition)
     * * to left of partition and all greater elements to right
     * * of partition
     *
     * @param list  array
     * @param start index of start (first one in array list)
     * @param end   index of end  (last one in array list)
     * @return
     */
    public static int partition(int list[], int start, int end) {
        // 每次都以最右边的元素作为基准值，即参照物
        // take the last element as the partition.
        int partition = list[end];
        int left = start; // define the index of left be start 定义左指针
        int right = end - 1; // define the index of right be end - 1 定义右指针
        // check each element 开始找数据
        while (true) {
            // 1. 从左边依次找数据，找到第一个比参照物大的数据
            // left < end : index(left) must be less than index(end)  下标不能越界，
            // when list[left] <= partition, keep check, move the index of left to next
            // 左指针<=参照物，则继续找，直到找到比左指针数据大的数据指针位置
            while (left < end && list[left] <= partition) {
                // 从左边开始遍历，如果比基准值小，就继续向右走
                // then checks each element
                left++; // 左指针位置++
            }
            // 左右两个指针合并到了同一位置，循环结束
            // if index(left) = index(end), then got same place for both index
            if (left == end) {
                // end is biggest, then end is partition 参照物（end）是最大值 即参照物为分界点
                break;
            }
            // 2. 从右边依次找数据，找到第一个比参照小的数据   <-- end
            // right >= start : index(right) must be equals or greater than index(partition) 下标不能越界，
            // when list[right] >= partition, keep check, move the index of right to previous 右指针>=参照物，则继续找，直到找到比右指针数据小的数据指针位置
            while (right >= start && list[right] >= partition) {
                right--; // index(right)-- 右指针位置--
            }

            // 3. 比较是否出现交叉（left and right）
            // left < right : index(left) < index(right), swap them 则没有交叉，则交换左右数据的数据
            // if left < right , swap list[left] and list[right]
            if (left < right) {
                // 4. 如果没有交叉，交换左右位置的数据
                int temp = list[left];
                list[left] = list[right];
                list[right] = temp;
            } else {
                // 5. 如果出现交叉， 交换左指针和参照物的值，结束
                //  left > right : index(left) > index(right), 则交叉，则交换左指针和参照物(end)的数据
                // if left > right, swap list[left] and list[end]
                int temp = list[left];
                list[left] = list[end];
                list[end] = temp; //
                break; // got partition position 跳出循环，找到分界点
            }
        }
        return left; // return the partition position  即左指针就是分界点的位置
    }

    public static void main(String[] args) {
        int list[] = new int[]{4, 9, 11, 8, 67, 3, 4, 2, 32, 34, 41, 6};
        System.out.println("Print Array:");
        print(list);
        quickSort(list, 0, list.length - 1);
        System.out.println("Quick Sort");
        print(list);
    }

    // traverse Integer data array and output
    public static void print(int list[]) {
        for (Integer data : list) {
            System.out.print(data + ", ");
        }
        System.out.println();
    }
}
