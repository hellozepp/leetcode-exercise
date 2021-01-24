package suanfa.leetcode;

public class a35 {
    public static int binarySearch(int[]arr,int target){
        if(arr==null||arr.length==0){
            return -1;
        }
        int left=0;int right = arr.length-1;
        while (left+1<right){
            int mid = right+(right-left)/2;
            if (arr[mid]==target){
                return mid;
            }else if (arr[mid]>target){
                left = mid;
            }else {
                right = mid;
            }
        }
        if (arr[left]==target){
            return left;
        }
        if (arr[right]==target){
            return right;
        }
        if (target<left){
            return left;
        }else if(target>right){
            return right;
        }else if (target>left&&target<right){return left;}
        return -1;
    }
    public static void main(String[] args) {

    }
}
