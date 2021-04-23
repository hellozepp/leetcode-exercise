package suanfa.playWithAlgorithmsData.binarysearch;

// 非递归的二分查找算法
public class BinarySearch {

    // 我们的算法类不允许产生任何实例
    private BinarySearch() {
    }

    // 二分查找法,在有序数组arr中,查找target
    // 如果找到target,返回相应的索引index
    // 如果没有找到target,返回-1
    public static int find(Comparable[] arr, Comparable target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (arr[mid].compareTo(target) == 0) {
                return mid;
            }

            if (arr[mid].compareTo(target) > 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }

    int find1(int num[], int key) {
        int low = 0;
        int high = num.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (num[mid] < key) {
                low = mid + 1;
            } else if (num[mid] > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    //	first position
    static int find2(Integer num[], int key) {
        if (num == null || num.length == 0) {
            return -1;
        }
        int left = 0;
        int right = num.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (num[mid] < key) {
                left = mid;
            }
            if (num[mid] >= key) {
                right = mid;
            }
        }
        if (num[left] == key) //一开始index:0就是key
            return left;
        if (num[right] == key) return right;
        return -1;
    }

    //	last position
    int find3(Integer num[], int key) {
        if (num == null || num.length == 0) {
            return -1;
        }
        int left = 0;
        int right = num.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (num[mid] > key) {//只是这里改变
                right = mid;
            }
            if (num[mid] <= key) {//只是这里改变+ 保留在左边,切掉多余的,范围集中到lastP
                left = mid;
            }
        }
        if (num[left] == key)
        return left;
        if (num[right] == key) return right;
        return -1;
    }

    // 测试非递归的二分查找算法
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new Integer(i);
        }

        // 对于我们的待查找数组[0...N)
        // 对[0...N)区间的数值使用二分查找，最终结果应该就是数字本身
        // 对[N...2*N)区间的数值使用二分查找，因为这些数字不在arr中，结果为-1
//        for (int i = 0; i < 2 * N; i++) {
        for (int i = 0; i <  N; i++) {
//            int v = BinarySearch.find(arr, new Integer(i));
            int v = BinarySearch.find2(arr, new Integer(i));
            if (i < N) {
                assert v == i:"assert";
            } else {
                assert v == -1:"assert";
            }
            if (v == -1 || arr[v]!=i){
                System.out.println(false);
            }
        }

        return;
    }
}
