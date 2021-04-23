package suanfa.playWithAlgorithmsData.sort;


import java.util.LinkedList;
/**1344
 *
 * ge:1344%10=1344/1%10
 * shi:1344/10%10
 * bai:1344/100%10
 * @author Administrator
 * 基数排序
 */
public class RadixSort {
	public static void main(String[] args) {
		int array[]={1,1,1,3,5,6,7,9,12,89,13123,10};
		new RadixSort().sort(array);
		for(int a:array) {
			System.out.print(a + " ");
		}
	}
	void sort(int []array){
		//1.????????????
		int max = findMax(array);
		int time = 0;
		while(max>0){
			max/=10;
			time++;
		}
		//2.????10??????
		LinkedList<Integer> queue[]=new LinkedList[10];
		for(int i=0;i<10;i++){
			queue[i]=new LinkedList<>();
		}
		//3.????time?????????
		for(int i=0;i<time;i++){
			//3.1???????????
			for(int j=0;j<array.length;j++){
				//queue[array[j]%(int)Math.pow(10, i+1)/(int)Math.pow(10, i)].add(array[j]);
				queue[array[j]/(int)Math.pow(10, i)%10].add(array[j]);
			}
			//3.2??????????
			int count = 0;
			for(int k=0;k<10;k++){
				while(!queue[k].isEmpty()){
					array[count++]=queue[k].remove();
				}
			}
		}
	}

	public int findMax(int[] array) {
		int max = 0;
		for(int j=0;j<array.length;j++){
			if(array[j]>array[max]){
				max = j;
			}
		}
		return array[max];
	}
	
}
