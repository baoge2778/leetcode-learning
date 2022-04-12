package com.company;

/**
 符合下列属性的数组 arr 称为 山脉数组 ：
 arr.length >= 3
 存在 i（0 < i < arr.length - 1）使得：
 arr[0] < arr[1] < ... arr[i-1] < arr[i]
 arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/peak-index-in-a-mountain-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_852 {

    public static void main(String[] args) {
        int[] n = {
                50283,81520,116899,137742,148291,
                159119,224336,266740,275267,311122,
                467541,532917,536563,567754,595798,
                622939,684110,856903,919054,983296,
                998699,960909,880105,851420,837814,
                836037,801217,748586,732053,727204,
                551817,517556,511404,511315,458646,
                371036,362041,336769,291098,270647,
                208588,202500,192602,190062,183265,
                164637,159618,132289,67914,57544};
        System.out.println(peakIndexInMountainArray(n));
    }

//    public static int peakIndexInMountainArray(int[] arr) {
//
//        int index = arr.length/2;
//        int len = arr.length/2;
//        while(len!=0) {
//            len = len/2;
//            if(arr[index -1] < arr[index] && arr[index] < arr[index + 1]) {
//                System.out.println("dd1:" + index);
//                System.out.println("dd11:" + len);
//                index += len;
//
//            }else if(arr[index -1] > arr[index] && arr[index]> arr[index + 1]) {
//                System.out.println("dd2:" + index);
//                System.out.println("dd22:" + len);
//                index -= len;
//
//            } else {
//                return index;
//            }
//        }
//        if(arr[index] < arr[index+1] && arr[index+1] > arr[index + 2]){
//            return index+1;
//        }else{
//            return index-1;
//        }
//    }

//    public static int peakIndexInMountainArray(int[] arr) {
//        for(int i=1;i<arr.length-1;i++){
//            if(arr[i-1] < arr[i] && arr[i] > arr[i+1]){
//                return i;
//            }
//        }
//        return 0;
//    }

    public static int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int left = 1, right = n - 2, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

}
