import java.lang.*;

class AllPairShortestPath {
    final static int INF = 99999, V = 5;

    void floydWarshall(int[][] dist)
    {

        int i, j, k;
        // i - src
        // j - dest
        // k - inter

        for (k = 0; k < V; k++) {
            // Pick all vertices as source one by one
            for (i = 0; i < V; i++) {
                // Pick all vertices as destination for the
                // above picked source
                for (j = 0; j < V; j++) {
                    // If vertex k is on the shortest path
                    // from i to j, then update the value of
                    // dist[i][j]
                    if (dist[i][k] + dist[k][j]
                            < dist[i][j])
                        dist[i][j]
                                = dist[i][k] + dist[k][j];
                }
            }
        }

        // Print the shortest distance matrix
        printSolution(dist);
    }

    void printSolution(int[][] dist)
    {
        System.out.println(
                "The following matrix shows the shortest "
                        + "distances between every pair of vertices");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Driver's code
    public static void main(String[] args)
    {

        int[][] graph = {
                { 0, 4, INF, 5, INF },
                { INF, 0, 1, INF, 6 },
                { 2, INF, 0, 3, INF },
                { INF, INF, 1, 0, 2},
                { 1, INF, INF, 4, 0}
        };
        AllPairShortestPath a = new AllPairShortestPath();

        // Function call
        a.floydWarshall(graph);
    }
}

// Contributed by Aakash Hasija
