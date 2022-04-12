package com.company;

public class Solution_657 {

    public static void main(String[] args) {
	// write your code here
        System.out.println(judgeCircle(""));
    }

    public static boolean judgeCircle(String moves) {
        int R = 0;
        int L = 0;
        int U = 0;
        int D = 0;
        String[] movesArr = moves.split("");

        for(int i=0;i<movesArr.length;i++) {
            switch (movesArr[i]){
                case "R":
                    R++;
                    break;
                case "L":
                    L++;
                    break;
                case "U":
                    U++;
                    break;
                case "D":
                    D++;
                    break;
                default:
                    break;
            }
        }
        if(R==L && U==D) {
            return true;
        } else {
            return false;
        }
    }
}
