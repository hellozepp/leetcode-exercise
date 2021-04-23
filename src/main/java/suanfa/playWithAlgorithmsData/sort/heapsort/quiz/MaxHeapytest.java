package suanfa.playWithAlgorithmsData.sort.heapsort.quiz;

public class MaxHeapytest<Item extends Comparable> {
    int capacity;
    int size;
    Item[] data;
    public MaxHeapytest(int capacity){
        this.capacity = capacity;
        this.data = (Item[]) new Comparable[capacity+1];//墙转成泛型类型，泛型是关键字不能直接new
        this.size = 0;
    }
    public void offer(Item j){
        assert size+1<=capacity:"越界";
        data[++size] = j;
        __shiftUp(size);
    }
    public Item poll(){
        assert size>0:"队列为空";
        Item temp = data[1];
        data[1]=data[size];
        size--;
        __shiftDown(1);
        return temp;
    }
    private void __shiftUp(int j) { //用于插入,插入节点提升
        while (j>1&&data[j].compareTo(data[(j-1)/2])>0){
            data[(j-1)/2]=data[j];
            j/=2;
        }
    }
    private void __shiftDown(int j) {//用于删除,最后节点交换到根节点后下降
        Item e = data[j];
        while (j*2+1<size){
            int k = j*2+1;
            if (k+1<size&&data[k].compareTo(data[k+1])<0){
                k++;
            }
            if (data[k].compareTo(e)<=0){
                break;
            }
            data[j]=data[k];
            j=k;
        }
        data[j]=e;
    }

    public static void main(String[] args) {

    }
}
