public class Main_Class {
    public static void main(String[] args) {
        Graph_class<String> graph = new Graph_class<>();

        graph.addVertex("Kabul");
        graph.addVertex("Herat");
        graph.addVertex("Ghazni");
        graph.addVertex("Mazar");

        graph.addEdge("Kabul", "Herat");
        graph.addEdge("Herat", "Ghazni");
        graph.addEdge("Ghazni", "Mazar");
        graph.addEdge("Kabul", "Mazar"); // it is belongs to unweighted edge

        // Testing BFS or BreathFirstSearch class
        Breadth_First_Search<String> bfs = new Breadth_First_Search<>(graph, "Kabul");
        System.out.println("BFS path from Kabul to Mazar: " + bfs.pathTo("Mazar"));

        // Testing DFS DepthFirstSearch class
        Depth_First_Search<String> dfs = new Depth_First_Search<>(graph, "Kabul");
        System.out.println("DFS path from Kabul to Mazar: " + dfs.pathTo("Mazar"));

        // testing Weighted graph
        WeightedGraph<String> weightedGraph = new WeightedGraph<>();
        weightedGraph.addVertex("Kabul");
        weightedGraph.addVertex("Herat");
        weightedGraph.addVertex("Ghazni");
        weightedGraph.addVertex("Mazar");

        weightedGraph.addEdge("Kabul", "Herat", 1.0);
        weightedGraph.addEdge("Herat", "Ghazni", 2.0);
        weightedGraph.addEdge("Ghazni", "Mazar", 1.0);
        weightedGraph.addEdge("Kabul", "Mazar", 4.0); // it belongs to weighted edge

        // Testing Dijkstra's algorithm
        Dijkstra_Search<String> ds = new Dijkstra_Search<>(weightedGraph, "Kabul");
        System.out.println("Dijkstra path from Kabul to Mazar: " + ds.pathTo("Mazar"));
        System.out.println("Dijkstra distance from Kabul to Mazar: " + ds.distTo("Mazar"));
    }
}
