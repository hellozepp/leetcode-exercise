package suanfa.playWithAlgorithmsData.sort;

public class HeapSort{
    public void sort(Comparable[] arr){
        int n = arr.length;
        for (int i = (n-2)/2;i>=0;i--){
            shiftDown(arr,n,i);
        }
        for(int j =n-1;j>0;j--){
            swap(arr,0,j);
            shiftDown(arr,j,0);
        }
    }

    private void shiftDown(Comparable[] arr, int n, int i) {
        while (i*2+1<n){
            int k = i*2+1;
            if (k+1<n&&arr[k+1].compareTo(arr[k])>0){
                k++;
            }
            if (arr[i].compareTo(arr[k]) >=0){
                break;
            }
            swap(arr,k,i);
            i = k;
        }
    }
    private void shiftUp(Comparable[] arr, int i){
        while (i>1&&arr[i].compareTo(arr[(i+1)/2])>0){
            swap(arr,i,(i+1)/2);
            i = (i+1)/2;
        }
    }

    private void swap(Comparable[] arr,int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
