package datastructure;

/**
 * @version $Id: null.java, v 1.0 2020/9/21 8:59 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description: 归并排序的demo
 * @since 1.0
 **/
public class MergeSort {

    public static void main(String[] args) {

        int[] a = new int[]{4,6,3,7,2,8,1,9};
        merge(a,0,a.length-1);
        for (int s:a){
            System.out.println(s);
        }
    }


    static void merge(int[] arr,int p, int r){
        if(p>=r){
            return;
        }
        int middle = (p+r)/2;
        merge(arr,p,middle);
        merge(arr,middle+1,r);
        merge_sort(arr,p,middle,middle+1,r);


    }

    static void merge_sort(int[] arr,int p,int lend,int rBegin,int r){

        int[] temp = new int[r-p];

        int i = p, j = rBegin,k = 0;

        while (i<=lend&&j<=r){
            if(arr[i]<= arr[j]){
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }

        }
        if(i<=lend){
            while (i<lend){
                temp[k++] = arr[i++];
            }
        }
        if(j<=r){
            while (j<r){
                temp[k++] = arr[j++];
            }
        }
        for(int q =0;q<r-p;q++){
            arr[p+q] = temp[q];
        }

    }
}
