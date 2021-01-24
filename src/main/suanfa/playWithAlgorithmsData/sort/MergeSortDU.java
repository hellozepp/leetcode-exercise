package suanfa.playWithAlgorithmsData.sort;

public class MergeSortDU {
    private static int[] temp;//初始化一个排序要用的副数组
    public static void mergeSort(int[] arr) {
        int L = arr.length;//得到参数数组长度L
        temp = new int[L];//定义数组长度

        for(int x=1; x<L; x = x+x){//定义微型数组的长度，初始为1
            for(int y =0; y <L-x; y += x+x) {//定义微型数组的索引 合并到原数组2倍
                merge(arr,temp,0,y+x-1,Math.min(y+x+x-1, L-1));//Math.min(y+x+x-1, L-1)最大长度小于边界
                }
            }
        }

    public static void merge(int[] arr,int[] temp,int min,int mid,int max) {
        int i = min;
        int j = mid + 1;

        for(int x=min;x<=max;x++) {
            temp[x]=arr[x];
            }

        for(int x=min;x<=max;x++){
            if(i>mid) {
                arr[x] = temp[j++];
                }else if(j>max) {
                arr[x] = temp[i++];
                }else if(temp[i]>temp[j]){
                arr[x]=temp[j++];
                }else {
                arr[x] = temp[i++];
                }
            }
        }
    }
