package suanfa.interview;

import suanfa.playWithAlgorithmsData.tree.TreeNode;

public class 中序后序生成树 {
    int[] post;
    int[] in;
    public TreeNode solution(int[] arr1,int[] arr2){
        in = arr2;
        post = arr1;
        return  bulid(0,arr1.length-1,0,arr2.length-1);
    }

    private TreeNode bulid(int st1, int end1, int st2, int end2) {
        if (st1>end1){
            return null;
        }
        TreeNode r = new TreeNode(post[end1]);
        int find = -1;
        for(int i = end2;i>=st2;i--){
            if (post[i]==r.val){
                find = i;
            }
        }
        if (find ==-1){
            return null;
        }
        //st1,st1+c st1+c+1,end1-1  end1
        //st2,find-1 find find+1,end2
        int c = find-st2;
        r.left = bulid(st1,st1+c,st2,find-1);
        r.right = bulid(st1+c+1,end1-1,find+1,end2);
        return r;
    }

    public static void main(String[] args) {
          int[] preSort = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inSort = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode solution = new 前序中序生成树().solution(preSort, inSort);
        solution.inOrder(solution);
    }
}
