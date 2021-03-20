package Try.aboutSort;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 8, 7, 2, 3, 1, 9};
        //System.out.println(Arrays.toString(shellSort(arr)));
        System.out.println(Arrays.toString(heapSort(arr)));
    }

    //希尔排序
    /*
     * 记忆：三层for循环
     * 时间复杂度：最坏o(nlog2n)  最好o(logn)
     *
     * */
    public static int[] shellSort(int[] arr) {
        if (arr.length <= 1) return arr;
        for (int i = arr.length / 2; i > 0; i /= 2) {//控制增量
            System.out.println("增量d:" + i);
            for (int j = i; j < arr.length; j++) {//里面两个for循环负责把分好组的值进行排序
                for (int k = j - i; k >= 0; k -= i) {
                    if (arr[k] > arr[k + i]) {
                        int num = arr[k + i];
                        arr[k + i] = arr[k];
                        arr[k] = num;
                    }
                }
            }
        }
        return arr;
    }

    /*
     * 堆排序
     * 时间复杂度：o(nlogn)
     * */
    public static int[] heapSort(int[] arr) {
        //构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {//从第一个非叶子节点开始，调整堆,从下至上，从有到左
            adjustHeap(arr, 0, arr.length);
        }
        //调整堆结构
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);//先交换堆根和最后一个元素
            adjustHeap(arr, 0, i);//调整剩下的堆的内容
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp = arr[i1];
        arr[i1] = arr[i];
        arr[i] = temp;
    }

    private static void adjustHeap(int[] arr, int i, int j) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < j; k++) {
            if (k + 1 < j && arr[k] < arr[k + 1]) {//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if (arr[k] > temp) {//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
