package graph.treealgorithms;

/*
 * Determining the diameter of a tree is a special case of the graph diameter problem which can be
 * solved in linear time.
 *
 * Time Complexity: O(V + E)
 */

import java.util.ArrayList;
import java.util.List;

public class TreeDiameter {

    // Set MAX_NUM_NODES to be the maximum number of nodes that will ever
    // be present in the tree you wish to find the diameter of. Also, you must make
    // sure you label the tree nodes in the range [0, MAX_NUM_NODES)
    static int MAX_NUM_NODES = 10;

    // Do a DFS and return a tuple (#nodes seen, index) to/of furthest node
    private static int[] dfs(List<List<Integer>> graph, int at, int parent) {
        int bestDist = 0, index = at;
        List<Integer> edges = graph.get(at);

        for (Integer to : edges) {
            if (to == parent) continue;
            int[] tuple = dfs(graph, to, at);
            if (++tuple[0] > bestDist) {
                bestDist = tuple[0];
                index = tuple[1];
            }
        }

        return new int[] {bestDist, index};
    }

    // Given an undirected tree setup as an adjacency and a
    // starting node list determine the diameter of this tree.
    public static int treeDiameter(List<List<Integer>> graph, int start) {

        if (graph == null) return 0;

        // Do DFS to find furthest node from the start
        int furthestIndex = dfs(graph, start, -1)[1];

        // Singleton
        if (furthestIndex == start) return 0;

        // Do another DFS, but this time from the furthest
        // node and record the distance to that node.
        int diameter = dfs(graph, furthestIndex, -1)[0];

        return diameter;
    }

    public static void main(String[] args) {

        List<List<Integer>> graph = createGraph(MAX_NUM_NODES);

        int numNodes = 8;
        addUndirectedEdge(graph, 0, 1);
        addUndirectedEdge(graph, 1, 2);
        addUndirectedEdge(graph, 2, 3);
        addUndirectedEdge(graph, 2, 4);
        addUndirectedEdge(graph, 4, 5);
        addUndirectedEdge(graph, 4, 6);
        addUndirectedEdge(graph, 6, 7);

        int diameter = treeDiameter(graph, 0);
        System.out.println("Tree diameter: " + diameter);
        if (diameter != 5) System.out.println("ERROR");
        resetGraph(graph, numNodes);

        numNodes = 10;
        addUndirectedEdge(graph, 0, 1);
        addUndirectedEdge(graph, 1, 2);
        addUndirectedEdge(graph, 2, 3);
        addUndirectedEdge(graph, 2, 4);
        addUndirectedEdge(graph, 4, 5);
        addUndirectedEdge(graph, 4, 6);
        addUndirectedEdge(graph, 6, 7);
        addUndirectedEdge(graph, 6, 9);
        addUndirectedEdge(graph, 7, 8);

        diameter = treeDiameter(graph, 5);
        System.out.println("Tree diameter: " + diameter);
        if (diameter != 6) System.out.println("ERROR");
        resetGraph(graph, numNodes);

        diameter = treeDiameter(graph, 3);
        System.out.println("Tree diameter: " + diameter);
        if (diameter != 0) System.out.println("ERROR");
    }

    private static List<List<Integer>> createGraph(int size) {
        List<List<Integer>> graph = new ArrayList<>(size);
        for (int i = 0; i < size; i++) graph.add(new ArrayList<>());
        return graph;
    }

    private static void resetGraph(List<List<Integer>> graph, int size) {
        for (int i = 0; i < size; i++) graph.get(i).clear();
    }

    private static void addUndirectedEdge(List<List<Integer>> graph, int from, int to) {
        graph.get(from).add(to);
        graph.get(to).add(from);
    }
}