package suanfa.leetcode;

public class a88 {
    public static int[] solition(int[] a,int[] b){
        if (a==null||b==null)return null;
        int index=0;
        int index1=0;int index2=0;
        int[] arr = new int[a.length+b.length];
        while (index1<a.length&&index2<b.length){
            if (a[index1]==b[index2]){
                arr[index++] = a[index1++];
            }else if (a[index1]<b[index2]){
                arr[index++]=a[index1++];
            }else {
                arr[index++]=b[index2++];
            }
        }
        while (index1!=a.length){
            arr[index++] = a[index1++];
        }
        while (index2!=b.length){
            arr[index++]=b[index2++];
        }
        return arr;
    }
    public static void main(String[] args) {

    }
}
