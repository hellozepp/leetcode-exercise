package suanfa.interview;

import java.util.Arrays;
import java.util.HashMap;


//定义节点
class BinaryTree {
    public int value;
    public BinaryTree leftNode;
    public BinaryTree rightNode;

    BinaryTree(int x) {
        value = x;
    }
}


/**
 * 根据前序序列：int[] preSort={1,2,4,7,3,5,6,8};
 *
 * 中序序列：int[] inSort=new int[]{4,7,2,1,5,3,8,6};
 *
 * 建立二叉树，求后序遍历等问题。
 *
 * 前序遍历，中序遍历，后序遍历，层次遍历，四种遍历中，必须包含中序遍历+三选一，两个序列就可以恢复出二叉树的形态。
 */
public class ConstrontTree {

    public static void main(String[] args) throws Exception {
        int[] preSort = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inSort = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTree root = startBuildTree(preSort, inSort);
    }

    /**
     * 中序和前序
     * @param preSort
     * @param inSort
     * @return
     * @throws Exception
     */
    //01递归生成树
    private static BinaryTree startBuildTree(int[] preSort, int[] inSort) throws Exception {
        //异常判断
        if (preSort == null || inSort == null) {
            return null;
        }
        if (preSort.length != inSort.length) {
            throw new Exception("不满足条件的非法输入！");
        }

        BinaryTree root = null;
        for (int i = 0; i < inSort.length; i++) {
            if (inSort[i] == preSort[0]) {
                root = new BinaryTree(preSort[0]);
                System.out.println(preSort[0]);

                root.leftNode = startBuildTree(
                        Arrays.copyOfRange(preSort, 1, i + 1),
                        Arrays.copyOfRange(inSort, 0, i));
                root.rightNode = startBuildTree(
                        Arrays.copyOfRange(preSort, i + 1, preSort.length),
                        Arrays.copyOfRange(inSort, i + 1, inSort.length));
            }
        }


        return root;
    }

    //方案二：
    //对于查找中序序列中根节点所在位置做进一步优化：map中存储前序的节点下标，方便直接分割前序数组
    public BinaryTree reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }

        return preIn(pre, 0, pre.length - 1, 0, map);
    }

    public BinaryTree preIn(int[] p, int pi, int pj, int ni, HashMap<Integer, Integer> map) {

        if (pi > pj) {
            return null;
        }
        BinaryTree head = new BinaryTree(p[pi]);
        //这样比原始方案一的方式效率要高
        int index = map.get(p[pi]);
        //index - ni为左子树的节点数
        // pi + index - ni 前序中所以左子树
        // pi + index - ni + 1 前序中所有右子数
        head.leftNode = preIn(p, pi + 1, pi + index - ni, ni, map);
        head.rightNode = preIn(p, pi + index - ni + 1, pj, index + 1, map);
        return head;
    }


}