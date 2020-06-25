package com.hfm.sort.integer;

/**
 * 堆排序
 *
 * @author shkstart 2018-12-17
 */
public class HeapSort {
    public static void heapSort(int[] data) {
        System.out.println("开始排序");
        int arrayLength = data.length;
        // 4.循环
        for (int i = 0; i < arrayLength - 1; i++) {
            // 1. 初始化 - 建堆  3. 调整
            // [30, 30, 21, 23, -30, -49, 21, 9, -16]
            buildMaxdHeap(data, arrayLength - 1 - i);
            // 2. 交换 - 交换堆顶和最后一个元素
            swap(data, 0, arrayLength - 1 - i);

            System.out.println(java.util.Arrays.toString(data));
        }
    }

    /**
     * 对data数组从0到lastIndex建大顶堆
     *
     * @param data
     * @param lastIndex
     */
    private static void buildMaxdHeap(int[] data, int lastIndex) {
        // 从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = lastIndex / 2 -1; i >= 0; i--) {
            // k保存当前正在判断的节点
            int k = i;
            // 如果当前k节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                // k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                // 如果biggerIndex小于lastIndex，即biggerIndex +1
                // 代表k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    // 如果右子节点的值较大
                    if (data[biggerIndex] - data[biggerIndex + 1] < 0) {
                        // biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                // 如果k节点的值小于其较大子节点的值
                if (data[k] - data[biggerIndex] < 0) {
                    // 交换它们
                    swap(data, k, biggerIndex);
                    // 将biggerIndex赋给k，开始while循环的下一次循环
                    // 重新保证k节点的值大于其左、右节点的值
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 交换 data 数组中i、j两个索引处的元素
     *
     * @param data
     * @param i
     * @param j
     */
    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void heapSort2(int[] array) {
        // 1.初始化
        initHeap(array, array.length, 0);
        int count = array.length;
        // 4.循环
        while (count > 1) {
            // 2.交换 堆顶元素与堆尾元素进行交换
            swap(array, 0, count - 1);
            // 未排序部分又少一个
            count--;
            // 3.调整 - 对新的堆进行初始化 过程自上而下，参数root=0
            initHeap(array, count, 0);

            System.out.println(java.util.Arrays.toString(array));
        }
    }

    public static void initHeap(int[] array, int count, int root) {
        // 建堆，从最后一个非叶子节点开始，而最后一个非叶子节点的下标为array.length/2-1
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            int maxChildIndex;
            // 待调整子堆的根节点必须是非叶子节点
            while (root <= count / 2 - 1) {
                // 需要在root、letfchild、rightchild中找到最大的值，
                // 因为最后一个非叶子节点有可能没有右孩子，所以要做出判断。
                if (root == count / 2 - 1 && count % 2 == 0) {
                    // 节点数量为偶数时，最后一个非叶子节点只有左孩子
                    maxChildIndex = 2 * root + 1;
                } else {
                    int leftChildIndex = 2 * root + 1;
                    int rightChildIndex = 2 * root + 2;
                    maxChildIndex = array[leftChildIndex] > array[rightChildIndex] ? leftChildIndex : rightChildIndex;
                }
                // 如果k节点的值小于其较大子节点的值
                if (array[root] < array[maxChildIndex]) {
                    // 交换它们
                    swap(array, root, maxChildIndex);
                    // 这里很重要，继续调整因交换结构改变的子堆
                    // 将biggerIndex赋给k，开始while循环的下一次循环
                    // 重新保证k节点的值大于其左、右节点的值
                    root = maxChildIndex;
                } else {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {9, -16, 21, 23, -30, -49, 21, 30, 30};
        System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
        heapSort2(data);
        System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
    }
}
