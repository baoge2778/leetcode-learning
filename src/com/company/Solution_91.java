package com.company;

import javax.swing.*;
import java.util.Arrays;

/**
 * 91. 解码方法
 *一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 *
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 *
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 *  
 */
public class Solution_91 {

    public static void main(String[] args) {
        System.out.println(numDecodings("230"));
    }

    //动态规划解决
    public static int numDecodings(String s) {
        if(s.charAt(0) == '0') {
            return 0;
        }
        int[] F = new int[s.length()];
        F[0] = 1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i) == '0') {
                if((s.charAt(i-1)-'0') >= '3' || s.charAt(i-1) == '0') {
                    return 0;
                }
                if(i==1) {
                    F[i] = F[i-1];
                }else{
                    F[i] = F[i-2];
                }
            }else if(s.charAt(i-1) == '0' || ((s.charAt(i-1)- '0') *10 + (s.charAt(i)- '0')  > 26)){
                F[i] = F[i-1];
            }else{
                if(i==1) {
                    F[i] = F[i-1] + 1;
                }else{
                    F[i] = F[i-1] + F[i-2];
                }
            }
        }
        System.out.println(Arrays.toString(F));
        return F[s.length()-1];
    }
}
