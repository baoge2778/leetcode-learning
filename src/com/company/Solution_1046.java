package com.company;

import org.omg.Messaging.SyncScopeHelper;
import sun.management.snmp.util.SnmpNamedListTableCache;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * 有一堆石头，每块石头的重量都是正整数。
 *
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 *
 * 示例：
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 *
 * 提示：
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 */
public class Solution_1046 {

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
//        int[] stones = {1,3};
        // 2 0 4 1 1 1
        // 0 0 2 1 1 1
        System.out.println(lastStoneWeight2(stones));
    }

    public static int lastStoneWeight(int[] stones) {
//        List list = Arrays.stream(stones).boxed().collect(Collectors.toList());
//        Collections.sort(list);
//        System.out.println(list);
        while(true){
            int min = 0, max = 0;
            int min_index = 0, max_index = 0;
            for (int i = 0; i < stones.length; i++) {
                if(stones[i] > max) {
                    if(max > min){
                        min = max;
                        min_index = max_index;
                    }
                    max = stones[i];
                    max_index = i;
                }else if(stones[i] > min) {
                    min = stones[i];
                    min_index = i;
                }
            }
            stones[min_index] = 0;
            stones[max_index] = max-min;
            if(min == 0){
//                break;
                return max;
            }
        }

    }


    public static int lastStoneWeight2(int[] stones) {
        //大顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b) -> b-a);
        for (int i = 0; i < stones.length; i++) {
            priorityQueue.add(stones[i]);
        }
        int max = 0 , min = 0;
        while(true){
            if(priorityQueue.peek() == null || priorityQueue.peek() == 0) {
                return max;
            }
            if(max != 0) {
                min = priorityQueue.peek();
                priorityQueue.remove();
                priorityQueue.add(max - min);
            }
            max = priorityQueue.peek();
            priorityQueue.remove();
        }
    }

    //官方
    public static int lastStoneWeight3(int[] stones) {
        //大顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b) -> b-a);
        for (Integer i: stones) {
            priorityQueue.add(i);
        }
        while(priorityQueue.size() > 1){
            int i = priorityQueue.poll();
            int j = priorityQueue.poll();
            if(i > j) {
                priorityQueue.add(i-j);
            }
        }
        return priorityQueue.isEmpty() ? 0 : priorityQueue.peek();
    }
}
