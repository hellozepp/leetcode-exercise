package suanfa.playWithAlgorithmsData.indexheap.test;

import suanfa.Utils;

public interface IndexMaxHeapTest<Item extends Comparable> {
    /**
     * 返回 size
     * 是否为空
     * insert
     * extractMax 弹出堆顶
     * extractMaxIndex 取出堆顶索引
     * getMax 取出对顶元素
     * get(i) 获取索引为i的元素
     * change(int i,Item newItem) 修改索引位置的元素
     * swap(int i,int j) 交换索引位置的元素
     * shiftUp
     * shiftDown
     * * */

}

class MyIndexMaxHeapTest<Item extends Comparable> implements IndexMaxHeapTest {
    //    维护的属性
    int capacity = 1 << 4;// aka 16
    int size = 0;
    Comparable[] data;//数据域
    int[] indexes;//索引域

    public MyIndexMaxHeapTest(int capacity) {
//        new HashMap<>()
        this.capacity = capacity;
        this.data = new Comparable[capacity + 1];//下标1开始
        this.indexes = new int[capacity + 1];
    }

    public void insert(Item item, int i) {
        assert size >= capacity : "数组越界";
        assert i + 1 < 1 && i >= capacity : "数组越界";
        data[++i] = item;
        indexes[++size] = i;
        __shiftUp(size);
    }

    private void __shiftUp(int k) {
        while (k > 1 && data[indexes[k]].compareTo(data[indexes[k / 2]]) > 0) {
            Utils.swap(indexes, indexes[k], indexes[k / 2]);
            k /= 2;
        }
    }
    private void shiftDown(int k){
        while (k*2<=size){
            int j=k*2;
            if (k*2+1>size&&data[indexes[k]].compareTo(data[indexes[k+1]])<0){
                j++;
            }
            if (data[indexes[k]].compareTo(data[indexes[j]])>=0){
                break;
            }
            Utils.swap(indexes,k,j);
            k=j;
        }
    }
}





























