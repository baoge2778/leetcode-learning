package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 264. 丑数 II
 *
 给你一个整数 n ，请你找出并返回第 n 个 丑数 。

 丑数 就是只包含质因数 2、3 和/或 5 的正整数。

 示例 1：

 输入：n = 10
 输出：12
 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 示例 2：

 输入：n = 1
 输出：1
 解释：1 通常被视为丑数。

 */
public class Solution_264 {

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(nthUglyNumber(417));
        System.out.println(System.currentTimeMillis()-a);

    }

    /**
     * 超时了。。。
     * @param n
     * @return
     */
    public static int nthUglyNumber(int n) {
        List<Double> list = new ArrayList<>();
        for(int i=0;i<n/8 + 4;i++){
            for(int j=0;j<n/8 + 4;j++){
                for(int k=0;k<n/8 + 4;k++){
                    list.add(Math.pow(2,i)*Math.pow(3,j)*Math.pow(5,k));
                }
            }
        }
        Collections.sort(list);
        return list.get(n-1).intValue();
    }
}
