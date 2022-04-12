package com.company;

import java.util.List;
import java.util.Stack;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class Solution_46 {

    public static Stack<Integer> stack = new Stack<Integer>();

    public static void main(String[] args) {
        permuteUnique(null);
    }

    /**
     * @param nums
     * @return
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> listT = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();

        int shu[] = {1,2,3};
        f(shu,3,0);
        return null;
    }

    /**
     *
     * @param shu   待选择的数组
     * @param targ  要选择多少个次
     * @param cur   当前选择的是第几次
     */
    private static void f(int[] shu, int targ, int cur) {
        if(cur == targ) {
            System.out.println(stack);
            return;
        }

        for(int i=0;i<shu.length;i++) {
            if(!stack.contains(shu[i])) {
                stack.add(shu[i]);
                f(shu, targ, cur+1);
                stack.pop();
            }

        }
    }


}
