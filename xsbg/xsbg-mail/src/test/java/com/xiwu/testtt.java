package com.xiwu;

import java.util.ArrayList;
import java.util.List;

import static reactor.core.Disposables.swap;

/**
 * @author ：wangjiahao
 * @date ：Created in
 * @description：
 */
public class testtt {
    public static void main(String[] args) {
//        [[1,3,4],[0,8],[2,5,6,9],[8],[7,9],[1,6,7],[7,8],[],[9],[9]]
        int [][] a=new int[][]{{1,3,4},{0,8},{2,5,6,9},{8},{7,9},{1,6,7},{7,8},{},{9},{9}};
        List<Integer> list=new Solution().eventualSafeNodes(a);
        for(int i:list){
            System.out.println(i);
        }

    }

}

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        //1：safe 2:no safe 3:working
        int[] book=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(graph[i].length!=0){
                isSafe(i,book,graph);

            }else{
                book[i]=1;
            }
        }

        List<Integer> list=new ArrayList();
        for(int i=0;i<book.length;i++){
            if(book[i]!=2 && book[i]!=3){
                list.add(i);
            }
        }
        return list;

    }
    public boolean isSafe(int stand,int[] book,int[][] graph){
        if(book[stand]==2){
            return false;
        }
        for(int i=0;i<graph[stand].length;i++){
            if(book[graph[stand][i]]==1){
               continue;
            }
            //到不安全节点
            if(book[graph[stand][i]]>1){
                book[stand]=2;
                return false;
            }
            //dfs
            if(book[graph[stand][i]]!=2 && book[graph[stand][i]]!=3){
                book[graph[stand][i]]=3;
                if(!isSafe(graph[stand][i],book,graph)){
                    // book[graph[stand][i]]=2;
                    book[stand]=2;
                    return false;
                }else{
                    book[graph[stand][i]]=1;
                }
                if(book[graph[stand][i]]==3){
                    book[graph[stand][i]]=0;
                }
            }

        }
        return true;
    }


}

