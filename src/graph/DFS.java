package graph;

import java.util.LinkedList;

public class DFS {

    public static void main(String[] args) {
        int v = 9;
        Graph graph = new Graph(v);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 8);
        graph.addEdge(7, 8);
        dfs(1, 4, graph);

    }

    static boolean found = false;

    private static void dfs(int s, int t, Graph graph) {
        found = false;
        int v = graph.getV();
        LinkedList<Integer> adj[] = graph.getAdj();
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev, adj);
        Graph.print(prev, s, t);
    }

    private static void recurDfs(int w, int t, boolean[] visited, int[] prev, LinkedList<Integer>[] adj) {
        if (found) return;
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev, adj);
            }
        }
    }
}
