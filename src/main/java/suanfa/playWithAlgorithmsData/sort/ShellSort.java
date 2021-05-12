package suanfa.playWithAlgorithmsData.sort;

public class ShellSort {
	public static void main(String[] args) {
		int num[] = { 3, 1, 5, 4, 123, 55, 33, 123 };
//		new ShellSort().sort(num);
		new ShellSort().sort1(num);
		for (int n : num) {
			System.out.print(n + " ");
		}

	}
	void sort(int num[]){
		int N = num.length;
		int h = 1;
		while(h<N/3) h = 3*h+1;
		while(h>=1){

			for(int i=h;i<N;i++){
				for(int j=i; j >= h  && Utils.less(num[j], num[j-h]);j-=h){//打水漂，迭代直到水漂的所有点
					Utils.exchange(num, j, j-h);
				}
			}

			h = h/3;
		}
	}
	/**
	 * 希尔排序
	 * @param arrays 需要排序的序列
	 */
	  void sort1(int[] arrays){
		if(arrays == null || arrays.length <= 1){
			return;
		}
		//增量
		int incrementNum = arrays.length/2;
		while(incrementNum >=1){
			for(int i=0;i<arrays.length;i++){
				//进行插入排序
				for(int j=i;j<arrays.length-incrementNum;j=j+incrementNum){
					if(arrays[j]>arrays[j+incrementNum]){
						int temple = arrays[j];
						arrays[j] = arrays[j+incrementNum];
						arrays[j+incrementNum] = temple;
					}
				}
			}
			//设置新的增量
			incrementNum = incrementNum/2;
		}
	}
}
