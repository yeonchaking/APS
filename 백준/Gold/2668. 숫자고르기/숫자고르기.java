import java.util.*;
import java.io.*;

public class Main {


    static int n;
    static ArrayList<ArrayList<Integer>> adjList;
    static ArrayList<Integer> list;

    static boolean[]visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        adjList =new ArrayList<>();
        visited = new boolean[n+1];
        list = new ArrayList<>();
        for(int i=0;i<=n;i++)adjList.add(new ArrayList<>());
        for(int i=1;i<=n;i++){
            int x =Integer.parseInt(br.readLine());
            adjList.get(i).add(x);
        }

        for(int i=1;i<=n;i++){
            visited[i]=true;
            DFS(i,i);
            visited[i]=false;
        }


        System.out.println(list.size());
        Collections.sort(list);
        for(int i :list) System.out.println(i);


    }

    static void DFS(int cur,int start){
     if(!visited[adjList.get(cur).get(0)]){
         visited[adjList.get(cur).get(0)]=true;
         DFS(adjList.get(cur).get(0),start);
         visited[adjList.get(cur).get(0)]=false;
     }
     if(adjList.get(cur).get(0)==start){
         list.add(start);
     }
    }



}