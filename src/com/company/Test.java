package com.company;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author zlb
 * @date 2021/4/1 10:31
 * @desc
 **/
public class Test {

    private static final int[] PRIVATE_VALUES = { 1,2,3 };
    private static final String STR = "123";

    static{
        PRIVATE_VALUES[1] = 0;
//        STR = "";
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(PRIVATE_VALUES));
    }


}
