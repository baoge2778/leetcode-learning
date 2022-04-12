package com.company;

import java.util.List;
import java.util.Stack;

/**
 *
 * 918. 环形子数组的最大和
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。
 *
 * 在此处，环形数组意味着数组的末端将会与开头相连呈环状。（形式上，当0 <= i < A.length 时 C[i] = A[i]，且当 i >= 0 时 C[i+A.length] = C[i]）
 *
 * 此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次。（形式上，对于子数组 C[i], C[i+1], ..., C[j]，不存在 i <= k1, k2 <= j 其中 k1 % A.length = k2 % A.length）
 *
 *
 */
public class Solution_918 {


    public static void main(String[] args) {
        int[] nums = {9,-4,-7,9};
        System.out.println(maxSubarraySumCircular2(nums));
    }

    public static int maxSubarraySumCircular2(int[] nums) {
        if(nums.length<2) {
            return nums[0];
        }
        //不同时包含首尾 普通处理方式
        //存储连续到当前的最大和
        int[] K = new int[nums.length];
        //存储当前的最大子序和
        int[] F = new int[nums.length];
        F[0] = nums[0];
        K[0] = nums[0];
        for(int i=1;i<nums.length;i++) {
            K[i] = Math.max(K[i-1] + nums[i] , nums[i]);
            F[i] = Math.max(F[i-1], K[i]);
        }

        //同时包含首尾 说明数组中间连续总和是最小的 所以求中间连续最小便可

        //存储连续到当前的最小和
        int[] K2 = new int[nums.length];
        //存储当前的最小子序和
        int[] F2 = new int[nums.length];
        F2[1] = nums[1];
        K2[1] = nums[1];
        int sum=0;
        for(int i=0;i<nums.length;i++) {
            if(i>1 && i<nums.length-1) {
                K2[i] = Math.min(K2[i-1] + nums[i] , nums[i]);
                F2[i] = Math.min(F2[i-1], K2[i]);
                System.out.println(F2[i]);
            }
            sum +=nums[i];
        }
        return Math.max(F[nums.length-1],sum - F2[nums.length-2]);
    }

    //时间复杂度太高
    public static int maxSubarraySumCircular(int[] nums) {
        if(nums.length<2) {
            return nums[0];
        }
        int[] union = new int[nums.length*2-1];

        for (int i = 0; i < nums.length ; i++) {
            union[i] = nums[i];
            if(i<nums.length-1){
                union[i+nums.length] = nums[i];
            }
        }
        int maxSum = Integer.MIN_VALUE;
        for (int j = 0; j < nums.length ; j++) {
            //存储连续到当前的最大和
            int[] K = new int[nums.length];
            //存储当前的最大子序和
            int[] F = new int[nums.length];
            F[0] = nums[j];
            K[0] = nums[j];
            for(int i=1;i<nums.length;i++) {
                K[i] = Math.max(K[i-1] + union[i+j] , union[i+j]);
                F[i] = Math.max(F[i-1], K[i]);
            }
            maxSum = Math.max(maxSum, F[nums.length-1]);

        }
        return maxSum;
    }


}
