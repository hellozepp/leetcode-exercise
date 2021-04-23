package contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import others.TreeNode;

/**
 * 
 * 2018.7.8 每周评测
 * 
 * @author Watcher
 *
 */
public class Contest92 {

	public static void main(String[] args) {
		Contest92 so = new Contest92();
		// System.out.println(so.isPalindrome(1221));
		System.out.println(so.primePalindrome(9989900));// 9989900
		// System.out.println(so.makePalindrome(123, false));
		// System.out.println(so.makePalindrome(123, true));
		// System.out.println(so.isPrime(9002009));
		/*
		 * TreeNode root = new TreeNode(3); root.left = new TreeNode(5); root.left.left = new TreeNode(6);
		 * root.left.right = new TreeNode(2); root.left.right.left = new TreeNode(7); root.left.right.right
		 * = new TreeNode(4);
		 * 
		 * root.right = new TreeNode(1); root.right.left = new TreeNode(0); root.right.right = new
		 * TreeNode(8);
		 * 
		 * System.out.println(new ContestSolution().subtreeWithAllDeepest(root).val);
		 */
	}

	/**
	 * 867. Transpose Matrix
	 * 
	 * Given a matrix A, return the transpose of A.
	 * 
	 * The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and
	 * column indices of the matrix.
	 * 
	 * @param A
	 * @return
	 */
	public int[][] transpose(int[][] A) {
		int m = A.length, n = A[0].length; // m*n 转换为n*m
		int[][] res = new int[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				res[j][i] = A[i][j];
			}
		}
		return res;

	}

	/**
	 * 865. Smallest Subtree with all the Deepest Nodes
	 * 
	 * Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.
	 * 
	 * A node is deepest if it has the largest depth possible among any node in the entire tree.
	 * 
	 * The subtree of a node is that node, plus the set of all descendants of that node.
	 * 
	 * Return the node with the largest depth such that it contains all the deepest nodes in its
	 * subtree.
	 * 
	 * @param root
	 * @return
	 */
	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return root;
		HashMap<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		HashSet<TreeNode> set = new HashSet<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			list.clear();
			while (size-- > 0) {
				root = queue.poll();
				list.add(root);
				if (root.left != null) {
					queue.offer(root.left);
					map.put(root.left, root);
				}
				if (root.right != null) {
					queue.offer(root.right);
					map.put(root.right, root);
				}
			}

		}
		if (list.size() == 1)
			return list.get(0);
		for (TreeNode n : list) {
			set.add(map.get(n));
		}
		while (set.size() > 1) {
			list = new ArrayList<TreeNode>(set);
			set.clear();
			for (TreeNode n : list) {
				set.add(map.get(n));
			}
		}

		return new ArrayList<TreeNode>(set).get(0);
	}

	public TreeNode subtreeWithAllDeepest2(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return root;
		while (root != null) {
			int left = depthOfNode(root.left, 1);
			int right = depthOfNode(root.right, 1);
			if (left == right)
				return root;
			root = left > right ? root.left : root.right;
		}
		return root;
	}

	private int depthOfNode(TreeNode n, int dep) {
		if (n == null)
			return dep - 1;
		return Math.max(depthOfNode(n.left, dep + 1), depthOfNode(n.right, dep + 1));
	}

	/**
	 * 866. Prime Palindrome
	 * 
	 * Find the smallest prime palindrome greater than or equal to N.
	 * 
	 * Recall that a number is prime if it's only divisors are 1 and itself, and it is greater than 1.
	 * 
	 * For example, 2,3,5,7,11 and 13 are primes.
	 * 
	 * Recall that a number is a palindrome if it reads the same from left to right as it does from
	 * right to left.
	 * 
	 * For example, 12321 is a palindrome.
	 * 
	 * @param N
	 * @return
	 */
	public int primePalindrome(int n) {
		while (n < 10) {
			if (isPrime(n))
				return n;
			n++;
		}
		if (n > 9989899)
			return 100030001;
		int m = n;
		int ns = Integer.parseInt((n + "").substring(0, ((n + "").length() + 1) / 2));
		boolean hasMid = (n + "").length() % 2 == 0 ? false : true; // 转换为回文的时候是否跳过中间位置
		if ((n + "").length() % 2 == 0) { // 偶数个位 不考虑中间位置
			m = makePalindrome(ns, hasMid);
		} else {
			m = makePalindrome(ns, hasMid);
		}
		int len = (ns + "").length();
		if (m < n) {
			ns++;
			if ((ns + "").length() > len) {
				// 产生了进位
				hasMid = !hasMid;
				if (!hasMid)
					ns /= 10;
				len = (ns + "").length();
			}
			m = makePalindrome(ns, hasMid);
		}

		while (true) {
			if (isPalindrome(m) && isPrime(m))
				return m;

			if ((ns + "").length() > len) {
				// 产生了进位
				hasMid = !hasMid;
				if (!hasMid)
					ns /= 10;
				len = (ns + "").length();
			}
			m = makePalindrome(ns, hasMid);
			ns++;
		}

	}

	public int makePalindrome(int n, boolean hasMid) {
		String ns = n + "";
		if (hasMid) {
			return Integer.parseInt(ns + new StringBuilder(ns.substring(0, ns.length() - 1)).reverse().toString());
		} else
			return Integer.parseInt(ns + new StringBuilder(ns).reverse().toString());

	}

	public boolean isPalindrome(int n) {
		if (n < 0)
			return false;
		if (n < 10)
			return true;
		int m = 0;
		while (n > m) {
			m = (m << 1) + (m << 3) + n % 10;
			n /= 10;
		}
		return n == m || (n == m / 10);
	}

	public boolean isPrime(int N) {
		if (N < 2)
			return false;
		int R = (int) Math.sqrt(N);
		for (int d = 2; d <= R; ++d)
			if (N % d == 0)
				return false;
		return true;
	}

}
