package suanfa.playWithAlgorithmsData.sort;

public class MergeSort {
    public static void main(String[] args) {
        int num[] = {1, 3, 2, 1, 1, 1, 5, 6, 8, 9, 0, 88};
        new MergeSort().sort(num, 0, num.length - 1);
        for (int n : num) {
            System.out.print(n + " ");
        }
        System.out.println(Utils.isSort(num));
    }

    void sort(int num[], int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            sort(num, low, mid);
            sort(num, mid + 1, high);
            //优化，左部分大于右部分最小值才merge
            if (num[mid] > num[mid + 1]) {
                merge(num, low, mid, high);
            }
        }

    }

    public void merge(int[] num, int low, int mid, int high) {
        int copyNum[] = new int[num.length];
        for (int i = 0; i <= high; i++) {
            copyNum[i] = num[i];
        }
        int left = low;
        int right = mid + 1;
        int current = low;
        while (left <= mid && right <= high) {
            if (copyNum[left] < copyNum[right]) {
                num[current++] = copyNum[left];
                left++;
            } else {
                num[current++] = copyNum[right];
                right++;
            }
        }
        int remaining = mid - left;//把左边超出的位数考到num
        for (int i = 0; i <= remaining; i++) {//数组拷贝函数
            num[current + i] = copyNum[left + i];
        }
    }

}
