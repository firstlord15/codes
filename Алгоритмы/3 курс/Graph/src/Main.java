public class Main {
    public static void main(String[] args)
    {
        int V = 6; // Number of vertices in graph
        int E = 7; // Number of edges in graph

        Graph graph = new Graph(V, E);
        //(A B C D E F)
        // add edge 0-1 (or A-B in above figure)
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 5;

        // add edge 0-2 (or B-C in above figure)
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 1;

        // add edge 1-2 (or B-D in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 2;

        // add edge 1-3 (or C-E in above figure)
        graph.edge[3].src = 2;
        graph.edge[3].dest = 4;
        graph.edge[3].weight = 1;

        // add edge 1-4 (or E-D in above figure)
        graph.edge[4].src = 4;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = -1;

        // add edge 3-2 (or D-F in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 5;
        graph.edge[5].weight = 2;

        // add edge 3-2 (or F-E in above figure)
        graph.edge[6].src = 5;
        graph.edge[6].dest = 4;
        graph.edge[6].weight = -3;

        // Function call
        graph.bellmanFord(graph, 0);
    }
}