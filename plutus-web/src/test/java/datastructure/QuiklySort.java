package datastructure;

/**
 * @version $Id: null.java, v 1.0 2020/9/19 12:11 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:$快速排序
 **/
public class QuiklySort {

    public static void main(String[] args) {
       // 选取中间值，把数组分为两部分，左边的比中间值小，右边的比中间值大
        // 递归分别处理左边的数据和右边的数据
        int[] arr = new int[]{4,6,3,7,2,8,1,9};
        sort(arr,0,arr.length-1);
        for(int a:arr){
            System.out.print(a);
        }
    }

    private static void sort(int[] arr, int p, int r) {
        if(p >= r){
            return;
        }
        int q = partition(arr, p, r);
        sort(arr,p,q-1);
        sort(arr,q+1,r);
    }

    private static int partition(int[] arr, int p, int r) {
        int key = arr[r];
        int i = p,j = r;
        while (i<j){
            while (arr[i]<=key&&i<j){
                i++;
            }
            while(arr[j]>=key&&i<j){
                j--;
            }
            if(i<j){
                int temp = arr[i];
                arr[i]= arr[j];
                arr[j] = temp;
            }

        }
        int temp = arr[r];
        arr[r]= arr[i];
        arr[i] = temp;
        return i;
    }

    // private static int partition(int[] arr, int p, int r) {
    //     int key = arr[r];
    //     int i = p;
    //     for(int j = p;j<r;j++){
    //         if(arr[j]< key){
    //             int temp = arr[i];
    //             arr[i] = arr[j];
    //             arr[j] = temp;
    //             i++;
    //         }
    //     }
    //     int temp = arr[r];
    //     arr[r] = arr[i];
    //     arr[i] = temp;
    //     return i;
    // }
}
