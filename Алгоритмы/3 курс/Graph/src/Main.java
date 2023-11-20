public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addNode("MIT");
        graph.addNode("Park");
        graph.addNode("Boston");
        graph.addNode("Tufts");
        graph.addNode("Gov");
        graph.addNode("Hay");
        graph.addNode("State");
        graph.addNode("Downtown");
        graph.addNode("China Town");
        graph.addNode("South");
        graph.addNode("Airport");

        graph.addEdge("MIT", "Park");
        graph.addEdge("Boston", "Park");
        graph.addEdge("Downtown","Park");
        graph.addEdge("Gov", "Park");
        graph.addEdge("Boston", "Tufts");
        graph.addEdge("Boston", "Downtown");
        graph.addEdge("Tufts", "China Town");
        graph.addEdge("Tufts", "South");
        graph.addEdge("Gov","Hay");
        graph.addEdge("Gov", "State");
        graph.addEdge("State", "Hay");
        graph.addEdge("State", "Downtown");
        graph.addEdge("China Town", "Downtown");
        graph.addEdge("South", "Downtown");
        graph.addEdge("South", "China Town");
        graph.addEdge("South", "Airport");
        graph.addEdge("State", "Airport");

        System.out.println(graph.getGraph());

        graph.DFS("MIT", null, null);
    }
}