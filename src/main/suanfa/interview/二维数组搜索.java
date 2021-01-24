package suanfa.interview;

/**
 * @Author: zhanglin
 * @Date: 2019/6/19
 * @Time: 12:36 AM
 */
public class 二维数组搜索 {
    public boolean Find(int[][] array, int target) {
        //定义多维数组的行数
        int m = array.length - 1;
        //定义多维数组的列数
        int i = 0;
        while (m >= 0 && i < array[0].length) {
            if (array[m][i] > target)
                m--;
            else if (array[m][i] < target)
                i++;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        二维数组搜索 s = new 二维数组搜索();
        int[][] b = {{1, 2, 3}, {4, 5, 6}};
        //测试一个两行三列的数组，目标值为0
        System.out.println(s.Find(b, 0));
    }
}
