package com.company;

/**
 * @date 2023/2/24 15:29
 *
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：5
 *
 * 提示：
 *
 * 0 <= n <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 **/
public class Solution_Offer10_1 {


    public static void main(String[] args) {
        int num = 100;
        Solution_Offer10_1 solution = new Solution_Offer10_1();
        System.out.println(solution.fib(num));
    }

    public int fib(int n) {
        int[] arr = new int[101];
        arr[0] = 0;
        arr[1] = 1;
        for(int i=2;i<=n;i++) {
            arr[i] = (arr[i-1] + arr[i-2]) % 1000000007;
        }
        return  arr[n] ;
    }
}







