package leetcode;

import java.util.Stack;

public class l32 {

    public static void main(String[] args) {
//        String s = ")()())";
//        String s = "()(()";
        String s = "()(())";
        int count = longestValidParentheses(s);
        System.out.println(count);
    }

    public static int longestValidParentheses(String s) {

        if (s == null || "".equals(s)) {
            return 0;
        }
        boolean[] flag = new boolean[s.length()];
        char[] cs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < cs.length; i++) {
            if (!stack.isEmpty() && stack.peek() == '(' && cs[i] == ')') {
                stack.pop();
                flag[i] = true;
                index = i - 1;
                while (flag[index] && index > 0) {
                    index--;
                }
                flag[index] = true;
            } else {
                stack.push(cs[i]);
            }
        }
        int count = 0;
        int temp = 0;
        for (boolean b : flag) {
            if (b) {
                temp++;
                count = temp > count ? temp : count;
            } else {
                temp = 0;
            }
        }
        return count;
    }
}
