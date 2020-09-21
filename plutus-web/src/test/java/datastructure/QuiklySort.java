package datastructure;

/**
 * @version $Id: null.java, v 1.0 2020/9/19 12:11 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:$快速排序
 **/
public class QuiklySort {

    public static void main(String[] args) {
        // 递归-把数组分成两部分
        // 合并两部分的时候保证有序

        int[] arr = new int[]{4,2,6,4,7,9,0,8,3};

        int[] result = merge_sort(arr);

        for(int i:result){
            System.out.println(i);
        }
    }
    // 归并排序（Java-递归版）
    static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
        if (start >= end)
            return;
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        merge_sort_recursive(arr, result, start1, end1);
        merge_sort_recursive(arr, result, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2)
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        while (start1 <= end1)
            result[k++] = arr[start1++];
        while (start2 <= end2)
            result[k++] = arr[start2++];
        for (k = start; k <= end; k++)
            arr[k] = result[k];
    }

    public static int[] merge_sort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        merge_sort_recursive(arr, result, 0, len - 1);
        return result;
    }
}
