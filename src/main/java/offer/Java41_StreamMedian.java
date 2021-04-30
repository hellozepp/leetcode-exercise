/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题41：数据流中的中位数
 * // 题目：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么
 * // 中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * // 那么中位数就是所有数值排序之后中间两个数的平均值。
 */
package offer;
import java.util.ArrayList;
import java.util.List;

public class Java41_StreamMedian {
	private Heap maxHeap = new Heap(Heap.isMaxHeap);
	private Heap minHeap = new Heap(Heap.isMinHeap);
	/**
	*插入思路：
	*1.平均分配，最大堆和最小堆之差不超过1
	*2.插入的次数为偶数时，插入到最小堆中；插入的次数为奇数时，插入到最大堆中
	*3.对于奇数：当出现待插入的数比最小堆堆顶元素大，此时需要将元素先插入到最小堆，再将最小堆堆顶元素插入到最大堆
	*4.对于偶数：当出现待插入的数比最大堆堆顶元素小，此时需要将元素先插入到最大堆，再将最大堆堆顶元素插入到最小堆
	*5.保证最大堆的元素比最小堆堆元素都要小
	*/
	public void Insert(Integer num) {
		//当插入为奇数时，则插入到最大堆中
		if (((maxHeap.size() + minHeap.size()) & 1) == 0) {
		    if (minHeap.size() != 0 && num > minHeap.peek()) {
		        minHeap.add(num);
		        maxHeap.add(minHeap.pop());
		    }
		    else {
		        maxHeap.add(num);
		    }
		}
		//当插入为偶数时，则插入到最小堆中
		else {
		    if (maxHeap.size() != 0 && num < maxHeap.peek()) {
		        maxHeap.add(num);
		        minHeap.add(maxHeap.pop());
		    }
		    else {
		        minHeap.add(num);
		    }
		}
	 }
	
	public Double GetMedian() {
		double mid = 0.0;
		if (((maxHeap.size() + minHeap.size()) & 1) == 0) {
		    mid = ((maxHeap.peek() + minHeap.peek()) / 2.0);
		}
		else {
		    mid = maxHeap.peek();
		}
		return mid;
	}
	
	//堆类，可直接设置最大堆最小堆
	class Heap {
		public List<Integer> list = null;
		public static final boolean isMaxHeap = true;
		public static final boolean isMinHeap = false;
		//true表示最大堆，false表示最小堆
		private boolean flag = true;
		public Heap() {
		    this.list = new ArrayList<Integer>();
		}
		public Heap(boolean flag) {
		    this.list = new ArrayList<Integer>();
		    this.flag = flag;
		}
		//获取堆大小
		public int size() {
		    return this.list.size();
		}
		//获取堆顶元素
		public int peek() {
		    if (list.size() == 0) {
		        return 0;
		    }
		    return list.get(0);
		}
		//插入元素，从插入点开始向上调整堆
		public void add(int val) {
			this.list.add(val);
			int i = list.size() - 1, index, parent, cur;
			while (i > 0) {
			    index = (i - 1) / 2;
			    parent = list.get(index);
			    cur = list.get(i);
			    if (flag == true && parent < cur) {
			        swap(index, i);
			    }
			    else if (flag == false && parent > cur) {
			        swap(index, i);
			    }
			    i = index;
			}
		}
		
		/**
		 * 将堆顶元素取出,并重新调整堆。
		 * 1>取出堆顶元素
		 * 2>将最后一个元素放到堆顶
		 * 3>向下调整堆
		 */
		public int pop() {
			if (list.size() == 0) {
			    return -1;
			}
			int res = list.get(0);
			list.set(0,list.get(list.size() - 1));
			list.remove(list.size()-1);
			int len = list.size() - 1 , i = 0;
			int left , right;
			while (i < len) {
			    left = (i << 1) + 1;
			    right= (i << 1) + 2;
			    int maxIndex = i;
			    if (flag == true) {
			        if (left < len && list.get(left) > list.get(maxIndex)) {
			            maxIndex = left;
			        }
			        if (right< len && list.get(right)> list.get(maxIndex)) {
			            maxIndex = right;
			        }
			    }
			    else {
			        if (left < len && list.get(left) < list.get(maxIndex)) {
			            maxIndex = left;
			        }
			        if (right< len && list.get(right)< list.get(maxIndex)) {
			            maxIndex = right;
			        }
			    }
			    if (maxIndex != i) {
			        swap(maxIndex,i);
			        i = maxIndex;
			    }
			    else {
			        break;
			    }
			}
			return res;
	    }
		
		//交换list中两个位置的元素
		public void swap(int i, int j) {
			int temp = list.get(i);
			list.set(i, list.get(j));
			list.set(j,temp);
		}
	}
}
