public class Main {
    public static void main(String[] args) {
        Graph graf = new Graph();

        graf.addNode("MIT");
        graf.addNode("Park");
        graf.addNode("Boston");
        graf.addNode("Tufts");
        graf.addNode("Gov");
        graf.addNode("Hay");
        graf.addNode("State");
        graf.addNode("Downtown");
        graf.addNode("China Town");
        graf.addNode("South");
        graf.addNode("Airport");

        graf.addEdge("MIT", "Park");
        graf.addEdge("Boston", "Park");
        graf.addEdge("Downtown","Park");
        graf.addEdge("Gov", "Park");
        graf.addEdge("Boston", "Tufts");
        graf.addEdge("Boston", "Downtown");
        graf.addEdge("Tufts", "China Town");
        graf.addEdge("Tufts", "South");
        graf.addEdge("Gov","Hay");
        graf.addEdge("Gov", "State");
        graf.addEdge("State", "Hay");
        graf.addEdge("State", "Downtown");
        graf.addEdge("China Town", "Downtown");
        graf.addEdge("South", "Downtown");
        graf.addEdge("South", "China Town");
        graf.addEdge("South", "Airport");
        graf.addEdge("State", "Airport");

        System.out.println(graf.getGraph());

        graf.DFS("MIT", null, null);
    }
}