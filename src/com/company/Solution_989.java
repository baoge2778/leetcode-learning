package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 * 示例 1：
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 *
 * 示例 2：
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 *
 * 示例 3：
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 *
 * 示例 4：
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 *
 * 提示：
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * 如果 A.length > 1，那么 A[0] != 0
 *
 *
 * 答案:
 * 另一个思路是将整个加数 KK 加入数组表示的数的最低位。
 *
 * 上面的例子 123+912123+912，我们把它表示成 [1,2,3+912][1,2,3+912]。
 * 然后，我们计算 3+912=9153+912=915。55 留在当前这一位，将 910/10=91910/10=91 以进位的形式加入下一位。
 *
 * 然后，我们再重复这个过程，计算 [1,2+91,5][1,2+91,5]。我们得到 9393，33 留在当前位，
 * 将 90/10=990/10=9 以进位的形式加入下一位。继而又得到 [1+9,3,5][1+9,3,5]，重复这个过程之后，
 * 最终得到结果 [1,0,3,5][1,0,3,5]。
 *
 * public List<Integer> addToArrayForm(int[] A, int K) {
 *         List<Integer> res = new ArrayList<Integer>();
 *         int n = A.length;
 *         for (int i = n - 1; i >= 0 || K > 0; --i, K /= 10) {
 *             if (i >= 0) {
 *                 K += A[i];
 *             }
 *             res.add(K % 10);
 *         }
 *         Collections.reverse(res);
 *         return res;
 *     }
 *
 */
public class Solution_989 {

    public static void main(String[] args) {
        int[] A = {9,9,9,9,9,9,9,9,9,9};
        int K = 1;
        System.out.println(addToArrayForm(A, K));
    }

    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new ArrayList<>();

        List<Integer> kList = new ArrayList<>();
        String strK = String.valueOf(K);

        for(int i=0;i<strK.length();i++){
            kList.add(Integer.parseInt(String.valueOf(strK.charAt(i))));
        }
        int len = A.length > kList.size()?A.length:kList.size();
        int step = 0;
        for(int i=1;i<=len;i++){
            int a = A.length>=i?A[A.length-i]:0;
            int k = kList.size()>=i?kList.get(kList.size()-i):0;
            int ak = a + k + step;
            if(ak>=10){
                step = 1;
                ak = ak - 10;
            }else{
                step = 0;
            }
            list.add(ak);
        }
        if(step == 1) {
            list.add(1);
        }
        Collections.reverse(list);
        return list;
    }
}
