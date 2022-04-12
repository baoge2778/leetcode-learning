package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution_841 {

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> list1 = new ArrayList<Integer>(){{
            add(1);
        }};
        List<Integer> list2 = new ArrayList<Integer>(){{
            add(1);
            add(1);
        }};
        rooms.add(list1);
        rooms.add(list2);
        System.out.println(canVisitAllRooms(rooms));
    }

    static List<Integer> openList = new ArrayList<>();

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms.size() == 0) {
            return true;
        }
        openList.add(0);
        jump(rooms.get(0), rooms);
        System.out.println(openList);
        if(openList.size() == rooms.size()) {
            return true;
        } else {
            return false;
        }
    }

    static void jump(List<Integer> list, List<List<Integer>> rooms) {
        for (Integer i: list) {
            if(!openList.contains(i)) {
                openList.add(i);
                jump(rooms.get(i),  rooms);
            }
        }

    }
}
