package suanfa.playWithAlgorithmsData.binarysearch.quiz;

public class TestBinarySearch {
    //递归版本
    public static int search1(int[] arr, Integer l, Integer r, Integer target) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] > target) {
            return search1(arr, l, mid - 1, target);
        } else {
            return search1(arr, mid + 1, r, target);
        }
    }

    public static int search1(int[] arr, Integer target) {
//        return search1(arr, 0, arr.length - 1, target);
        //非递归版本
        int l = 0;
        int r = arr.length - 1;
        while (l<=r) {
            int mid = l + (r - l) / 2;
            if (arr[mid]==target){
                return mid;
            }else if (arr[mid]>target){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return -1;
    }


    // 测试递归的二分查找算法
    public static void main(String[] args) {

        int N = 1000000;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new Integer(i);
        }
        for (int i = 0; i < 2 * N; i++) {
            int v = search1(arr, new Integer(i));
            if (i < N) {
                System.out.println(v);
                assert v == i;
            } else {
                System.out.println(v);
                assert v == -1;
            }
        }

        return;
    }
}
