import java.util.*;

public class Graph {
    private final Map<String, List<String>> graph = new LinkedHashMap<>();
    private final List<String> nodeList = new ArrayList<>();

    public void addNode(String node) {
        if (!graph.containsKey(node)) {
            graph.put(node, new ArrayList<>());
            nodeList.add(node);
        }
    }

    public void addEdge(String node1, String node2) {
        if (graph.containsKey(node1) && graph.containsKey(node2) && !graph.get(node1).contains(node2) && !graph.get(node2).contains(node1)) {
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
    }

    public void deleteNode(String node) {
        if (graph.containsKey(node)) {
            List<String> nodes = graph.get(node);
            graph.remove(node);
            for (String nod : nodes) {
                graph.get(nod).remove(node);
            }

            nodeList.remove(node);
        }
    }

    public void deleteEdge(String node1, String node2) {
        if (graph.containsKey(node1) && graph.containsKey(node2)) {
            graph.get(node1).remove(node2);
            graph.get(node2).remove(node1);
        }
    }

    public StringBuilder getGraph() {
        StringBuilder result = new StringBuilder();

        for (String str: graph.keySet()) {
            result.append("key: ").append(str).append(", value: ").append(graph.get(str)).append("\n");
        }

        return result;
    }

    public void DFS(String startNode, Set<String> visited, int[] distance) {
        if ((visited == null) | (distance == null)){
            visited = new HashSet<>();
            distance = new int[nodeList.size()];
        }

        visited.add(startNode);

        for (String nextNode: graph.get(startNode)) {
            if (!visited.contains(nextNode)) {
                distance[nodeList.indexOf(nextNode)] = distance[nodeList.indexOf(startNode)] + 1;

                System.out.println("Start node: " + startNode + ", Next node: " + nextNode  + ", Distance: " + Arrays.toString(distance));
                DFS(nextNode, visited, distance);
            }
        }
    }
}