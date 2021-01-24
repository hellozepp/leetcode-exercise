package suanfa;



/**
 * Created by docker on 2017/10/9.
 * assert 参数：-ea:suanfa.MiniQuiz
 * true 不中断
 * 使一个com.test包中的断言无效，可以使用：
 -da:com.tree
 要使一个包中的所有子包中的断言能够有效或无效，在包名后加上三个点。例如：
 -ea:com.tree...
 */
public class MiniQuiz {
    public static void main(String[] args) {
        //有序集合
        int[] arr = Utils.generateOrderArray(10, 0, 10);
//        int[] arr = Utils.generateRandomArray(10, 0, 10);
        int[] arrCp = arr.clone();
        Utils.printArr(arrCp);
       /* selectionSort(arrCp);
        Utils.printArr(arrCp);
        System.out.println(Utils.isSort(arrCp));*/
        int i = binarySearch(arr, arr[9]);
        System.out.println("binarySearch:find ("+arr[9]+") is"+arr[i]);
    }

    private static void selectionSort(int[] arr) {
        for (int i=0;i<arr.length-1;i++){
            int min = i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<arr[min]){
                    min= j;
                }
            }
            if (min!=i)  Utils.swap(arr,i,min);
        }
    }

    public static int  binarySearch(int[] arr, int target) {
        int l = 0;
        int r= arr.length-1;
        while (l<=r){
            int mid = (l+r)/2;
            if (arr[mid]==target){
                return mid;
            }else if(arr[mid]<target){
                l = mid+1;
            }else r = mid-1;
        }

        return -1;
    }

}
