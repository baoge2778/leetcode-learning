package com.company;

import java.util.Arrays;

/**
 *
 * 171. Excel 表列序号
 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。

 例如，

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 ...
 *  
 */
public class Solution_171 {

    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
    }

    public static int titleToNumber(String columnTitle) {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int count=0;
        for(int i=0;i<columnTitle.length();i++){
            count += Math.pow(26,columnTitle.length()-1-i) * (str.indexOf(columnTitle.substring(i,i+1))+1);
        }
        return count;
    }

}
