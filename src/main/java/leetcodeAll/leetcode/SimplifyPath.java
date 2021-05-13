package leetcodeAll.leetcode;

import java.util.Stack;

/**
 * 71. Simplify Path
 *
 * @author Watcher
 *
 */
public class SimplifyPath {

    /**
     * 最快
     *
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        char[] p = path.toCharArray();
        char[] simple = new char[p.length];
        int[] starts = new int[p.length];
        int i = 0, j = 0, k = 0;
        while (i < p.length) {
            if (p[i] == '/') {
                starts[k] = j;
                simple[j++] = ('/');
                i++;
                while (i < p.length && p[i] == '/') {
                    i++;
                }
            } else if (p[i] == '.' && (i + 1 >= p.length || p[i + 1] == '/')) {
                i += 1;
                j--;
            } else if (p[i] == '.' && p[i + 1] == '.' && (i + 2 >= p.length || p[i + 2] == '/')) {
                if (k > 0)
                    k--;
                j = starts[k];
                i += 2;
            } else {
                while (i < p.length && p[i] != '/') {
                    simple[j++] = p[i++];
                }
                k++;
            }
        }
        if (j > 0 && simple[j - 1] == '/')
            j--;
        return j == 0 ? "/" : new String(simple, 0, j);
    }

    /**
     * 使用一个指针和原数组模仿栈，耗时5m
     *
     * @param path
     * @return
     */
    public String simplifyPath3(String path) {
        String[] ps = path.split("/");
        int index = 0;
        for (int i = 0; i < ps.length; i++) {
            if (ps[i].equals(".") || ps[i].isEmpty())
                continue;
            if (ps[i].equals("..")) {
                if (index > 0) {
                    index--;
                }
            } else {
                ps[index++] = ps[i];
            }
        }
        if (index == 0)
            return "/";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index; i++)
            sb.append('/').append(ps[i]);
        return sb.toString();
    }

    /**
     * 栈实现，耗时7ms
     *
     * @param path
     * @return
     */
    public String simplifyPath2(String path) {
        Stack<String> stack = new Stack<String>();
        String[] ps = path.split("/");
        for (int i = 0; i < ps.length; i++) {
            if (ps[i].equals(".") || ps[i].isEmpty())
                continue;
            if (ps[i].equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else
                stack.push(ps[i]);
        }
        if (stack.isEmpty())
            return "/";
        StringBuilder sb = new StringBuilder();

        for (String s : stack)
            sb.append("/").append(s);
        return sb.toString();
    }
}
