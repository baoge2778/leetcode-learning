package com.company;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 给定一个化学式formula（作为字符串），返回每种原子的数量。
 *
 * 原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。
 *
 * 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。
 *
 * 两个化学式连在一起是新的化学式。例如 H2O2He3Mg4 也是化学式。
 *
 * 一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。
 *
 * 给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。
 *
 * 示例 1:
 *
 * 输入:
 * formula = "H2O"
 * 输出: "H2O"
 * 解释:
 * 原子的数量是 {'H': 2, 'O': 1}。
 * 示例 2:
 *
 * 输入:
 * formula = "Mg(OH)2"
 * 输出: "H2MgO2"
 * 解释:
 * 原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。
 * 示例 3:
 *
 * 输入:
 * formula = "K4(ON(SO3)2)2"
 * 输出: "K4N2O14S4"
 * 解释:
 * 原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。
 *
 *
 * 并列括号时候如何处理？？？？  “KJS(RO)(S)2”
 */
public class Solution_726 {

    public static void main(String[] args) {
	// write your code here
        String formula = "K(MgiO(OH)2)3";
        System.out.println(countOfAtoms(formula));
    }

    private static Pattern pattern = Pattern.compile("-?[0-9]+(\\\\.[0-9]+)?");

    private static boolean isNumber(String str) {
        Matcher m = pattern.matcher(str);
        return m.matches();
    }


    public static String countOfAtoms(String formula) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        while (formula.indexOf("(") != -1) {
            String sub = formula.substring(formula.lastIndexOf("(") + 1,formula.indexOf(")"));
            //获取括号后面数字
            int count = 0;
            //括号后面有数字
            if(formula.indexOf(")") + 1 < formula.length()
                    && isNumber(String.valueOf(formula.charAt(formula.lastIndexOf(")") + 1)))){
                count = Integer.parseInt(String.valueOf(formula.charAt(formula.lastIndexOf(")") + 1)));
                //生成去除最里面括号和后面数字的 新字符串
                formula = formula.substring(0, formula.lastIndexOf("(")) +
                        formula.substring(formula.indexOf(")") +2);
                //计算map中value
                for (String key: map.keySet()) {
                    map.put(key, map.get(key)*count);
                }
            } else {
                count = 1;
                formula = formula.substring(0, formula.lastIndexOf("(")) +
                        formula.substring(formula.indexOf(")") +1);
            }


            String s = "";
            for (int i = 0; i < sub.length(); i++) {
                if(Character.isUpperCase(sub.charAt(i))) {
                    if(!"".equals(s)) {
                        if(map.containsKey(s)) {
                            map.put(s, count + map.get(s));
                        }else{
                            map.put(s, count);
                        }
                        s = "";
                    }
                    s += sub.charAt(i);
                }else{
                    s += sub.charAt(i);
                }
            }
            if(map.containsKey(s)) {
                map.put(s, 1 + map.get(s));
            }else{
                map.put(s, 1);
            }
        }

        String s = "";
        for (int i = 0; i < formula.length(); i++) {
            if(Character.isUpperCase(formula.charAt(i))) {
                if(!"".equals(s)) {
                    if(map.containsKey(s)) {
                        map.put(s, 1 + map.get(s));
                    }else{
                        map.put(s, 1);
                    }
                    s = "";
                }
                s += formula.charAt(i);
            }else{
                s += formula.charAt(i);
            }
        }
        if(map.containsKey(s)) {
            map.put(s, 1 + map.get(s));
        }else{
            map.put(s, 1);
        }
        return  map.toString();
    }
}
