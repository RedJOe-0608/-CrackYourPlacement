package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s,int d, int w)
        {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void bfs(ArrayList<Edge>[] graph, int src)
    {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];

        q.add(src);

        while(!q.isEmpty())
        {
            int element = q.remove();

            if(!visited[element])
            {
                System.out.print(element+ " ");
    
                //mark visited
                visited[element] = true;
    
                //store all the neighbours in queue.
                for(int i=0;i<graph[element].size();i++)
                {
                    Edge e = graph[element].get(i);
                    q.add(e.dest);
                }

            }
        }
    }

    public static void main(String[] args) {
         /*
         
           (8)
        0 --------  1
                  /  \
             (1) /   \  (5)
                / (2) \
               2 ---   3
               |
          (3)  |
               |
              4
              */
              
            int V = 5;
            ArrayList<Edge>[] graph = new ArrayList[V];

            for(int i=0;i<V;i++)
            {
                graph[i] = new ArrayList<>();
            }

            //0 vertex
            graph[0].add(new Edge(0,1,8));

            //1 vertex
            graph[1].add(new Edge(1,0,8));
            graph[1].add(new Edge(1,2,1));
            graph[1].add(new Edge(1,3,5));

            //2 vertex
            graph[2].add(new Edge(2,1,1));
            graph[2].add(new Edge(2,3,2));
            graph[2].add(new Edge(2,4,3));

            //3 vertex
            graph[3].add(new Edge(3,1,5));
            graph[3].add(new Edge(3,2,2));
            
            //4 vertex
            graph[4].add(new Edge(4,2,3));

            bfs(graph, 3);

    }
    
}
