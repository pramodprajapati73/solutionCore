package DataStructure.graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    int V;
    LinkedList<Integer> adj[];

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i=0;i<V;i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void topologicalSort(int i){
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);
        for (int st = i;st<V;st++){
            if(!visited[st])
                topologicalSortUtil(st, stack, visited);
        }
        //print all the stack items
    }

    private void topologicalSortUtil(int node, Stack<Integer> stack, boolean[] visited){
        int currNode;
        visited[node] = true;
        Iterator<Integer> iterator = adj[node].iterator();
        while (iterator.hasNext()){
            currNode = iterator.next();
            if(!visited[currNode])
                topologicalSortUtil(currNode, stack, visited);
        }
        stack.push(node);
    }

    public int countIslands(int m[][], int ROW, int COL){
        int count  =0 ;
        boolean visited[][] = new boolean[ROW][COL];
        for(int i=0;i<ROW;i++){
            for(int j=0;j<COL;j++){
                if (m[i][j]==1 && !visited[i][j]){
                    DFS(m, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void DFS(int m[][], int i, int j, boolean visited[][]){
        int rowC[] = {-1,-1,-1,0,0,1,1,1};
        int colC[] = {-1,0,1,-1,1,-1,0,1};
        visited[i][j] = true;
        for (int k=0;k<8;k++){
            if(isSafe(5,5,i, j, m, visited))
                DFS(m, i+rowC[k], j+colC[k],visited);
        }
    }

    private boolean isSafe(int ROW,int COL, int row, int col, int m[][], boolean visited[][]){
        return (row>=0 || row <ROW)
                && (col>=0 || col<COL)
                && (m[row][col]==1) && !visited[row][col];
    }
}
