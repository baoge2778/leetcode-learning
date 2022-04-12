package com.company;

import com.sun.org.apache.xerces.internal.xs.XSNamedMap;

import java.util.*;

/**
 *
 * 在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。
 *
 * （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。
 *
 * 返回区域的数目。
 *
 */
public class Solution_959 {

    public static void main(String[] args) {
//        String[] grid = {" /","/ "};
//        String[] grid = {"/\\","\\/"};
//        String[] grid = {" /","  "};
        String[] grid = {" \\/ /\\/  /\\////\\////","\\\\//\\\\/  /// \\//\\//\\","   \\\\\\/ \\/\\//\\// /  ","\\\\/\\/\\\\\\\\/\\\\/\\/// /\\","\\\\////\\\\\\  \\// ////\\","\\\\\\/ /\\/ /\\\\///\\/\\\\/","\\/\\/ \\\\\\\\\\/\\\\// \\///","/ /  //\\/\\\\\\ \\\\\\\\\\ \\","\\\\\\\\\\ ///\\  ///\\\\ //"," \\\\ \\//\\/\\/ \\/\\/\\  /","\\\\\\/\\\\/ \\\\ \\ \\\\ //\\ ","/\\ //\\\\\\/ \\\\\\/ // /\\","/\\\\// /\\\\\\/\\\\\\/// \\ ","\\// / /////\\ /  \\\\\\ "," \\\\//\\   \\\\//\\\\ \\\\ \\","/\\//\\/// /\\ ///\\ \\\\\\","\\\\\\\\\\\\/// \\ \\//\\///\\","\\//// \\\\/\\// \\ // //"," /// \\ //\\///  \\\\// "," \\\\\\\\/\\\\/\\ \\\\//\\\\///"};
        //结果应该是29，不是27
        System.out.println(regionsBySlashes(grid));


    }

    static Map<String, Tree> map = new HashMap<String, Tree>();

    /**
     *
     * @param grid
     * @return
     */
    public static int regionsBySlashes(String[] grid) {
        Set<String> set = new HashSet<String>();
        Tree tree ;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[i].length();j++){
                String pre = i+""+j;
                switch (grid[i].charAt(j)) {
                    case ' ' :
                        tree = new Tree(pre + 1, "");
                        map.put(pre + 1,tree);
                        tree = new Tree(pre + 2, pre + 1);
                        map.put(pre + 2,tree);
                        tree = new Tree(pre + 3, pre + 1);
                        map.put(pre + 3,tree);
                        tree = new Tree(pre + 4, pre + 1);
                        map.put(pre + 4,tree);
                        if(j>0){
                            tree = new Tree(getRootNode(map.get(i+""+(j-1)+""+4)), pre + 1);
                            if(!getRootNode(map.get(i+""+(j-1)+""+4)).equals(pre + 1)){
                                map.put(getRootNode(map.get(i+""+(j-1)+""+4)),tree);
                            }

                        }
                        if(i>0){
                            tree = new Tree(getRootNode(map.get((i-1)+""+j+""+3)), pre + 1);
                            if(!getRootNode(map.get((i-1)+""+j+""+3)).equals(pre + 1)){
                                map.put(getRootNode(map.get((i-1)+""+j+""+3)),tree);
                            }
                        }
                        break;
                    case '/' :
                        tree = new Tree(pre + 1, "");
                        map.put(pre + 1,tree);
                        tree = new Tree(pre + 2, pre + 1);
                        map.put(pre + 2,tree);
                        tree = new Tree(pre + 3, "");
                        map.put(pre + 3,tree);
                        tree = new Tree(pre + 4, pre + 3);
                        map.put(pre + 4,tree);
                        if(j>0){
                            tree = new Tree(getRootNode(map.get(i+""+(j-1)+""+4)), pre + 1);
                            if(!getRootNode(map.get(i+""+(j-1)+""+4)).equals(pre + 1)){
                                map.put(getRootNode(map.get(i+""+(j-1)+""+4)),tree);
                            }
                        }
                        if(i>0){
                            tree = new Tree(getRootNode(map.get((i-1)+""+j+""+3)), pre + 1);
                            //不能子父节点相等
                            if(!getRootNode(map.get((i-1)+""+j+""+3)).equals(pre + 1)){
                                map.put(getRootNode(map.get((i-1)+""+j+""+3)),tree);
                            }

                        }
                        break;
                    case '\\' :
                        tree = new Tree(pre + 1, "");
                        map.put(pre + 1,tree);
                        tree = new Tree(pre + 2, "");
                        map.put(pre + 2,tree);
                        tree = new Tree(pre + 3, pre + 2);
                        map.put(pre + 3,tree);
                        tree = new Tree(pre + 4, pre + 1);
                        map.put(pre + 4,tree);
                        if(j>0){
                            tree = new Tree(getRootNode(map.get(i+""+(j-1)+""+4)), pre + 2);
                            if(!getRootNode(map.get(i+""+(j-1)+""+4)).equals(pre + 2)){
                                map.put(getRootNode(map.get(i+""+(j-1)+""+4)),tree);
                            }
                        }
                        if(i>0){
                            tree = new Tree(getRootNode(map.get((i-1)+""+j+""+3)), pre + 1);
                            if(!getRootNode(map.get((i-1)+""+j+""+3)).equals(pre + 1)){
                                map.put(getRootNode(map.get((i-1)+""+j+""+3)),tree);
                            }
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        //计算每个方格的根节点，去重
        for(Tree tree3 : map.values()){
//            System.out.println(getRootNode(tree3));
            set.add(getRootNode(tree3));
        }
        return set.size();
    }

    static String getRootNode(Tree tree) {
        if (!"".equals(tree.parent)) {
            return getRootNode(map.get(tree.parent));
        }
        return tree.val;
    }

}

class Tree {
    String val;
    String parent;
    Tree(String x, String y) {
        val = x;
        parent = y;
    }
}

