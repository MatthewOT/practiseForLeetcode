package com.practice.P1_100.P31_40;

public class longestValidParentheses {
    /*
    NO.32 最长有效括号
    给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

    示例 1:
    输入: "(()"
    输出: 2
    解释: 最长有效括号子串为 "()"

    示例 2:
    输入: ")()())"
    输出: 4
    解释: 最长有效括号子串为 "()()"
     */
    int solution1(String s){
        int max = 0;
        int len = s.length();
        if (len < 2) return 0;
        int[] dp = new int[len];
        //dp的定义也有问题，dp[i]为以i结尾的子串长度，若i为（则dp为0
        dp[0] = 0;
        for (int i = 1;i < len;i++){
            if (s.charAt(i) == ')'){
                /*
                大体思路是对的，但是没有考虑到()(())、()(())、()(())((((()
                这三种case的情况，需要对dp[i]的状态转移方程做一个修正
                状态转移的条件对了，但是状态转移方程（值的变化方式）错了
                 */
                if (s.charAt(i-1) == '('){
                    dp[i] = (i >= 2?dp[i-2]:0) + 2;
                }else if (i - dp[i-1] -1 >= 0 && dp[i - dp[i-1] -1] == '('){
                    dp[i] = dp[i-1] + 2;
                }
            }
            max = Math.max(max,dp[i]);
        }
        return dp[len-1];
    }

    public static void main(String[] args) {
        longestValidParentheses l = new longestValidParentheses();
        int a = l.solution1("()(())())))))(");
        System.out.println(a);
    }
}
