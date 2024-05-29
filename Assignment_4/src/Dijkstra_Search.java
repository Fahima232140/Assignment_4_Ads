import java.util.*;

public class Dijkstra_Search<Vertex> extends Search<Vertex> {
    private final Map<Vertex, Double> distTo;

    public Dijkstra_Search(WeightedGraph<Vertex> graph, Vertex source) {
        super(source);
        distTo = new HashMap<>();
        initialize_Distances(graph);
        search(graph, source);
    }

    private void initialize_Distances(WeightedGraph<Vertex> graph) {
        for (Vertex vertex : graph.getVertices().keySet()) {
            distTo.put(vertex, Double.POSITIVE_INFINITY);
        }
        distTo.put(source, 0.0);
    }

    @Override
    public void search(WeightedGraph<Vertex> graph, Vertex source) {
        PriorityQueue<VertexNode<Vertex>> pq = new PriorityQueue<>(Comparator.comparing(v -> distTo.getOrDefault(v.getData(), Double.POSITIVE_INFINITY)));
        mark(source);
        pq.add(graph.getVertex(source));

        while (!pq.isEmpty()) {
            VertexNode<Vertex> v = pq.poll();
            for (Map.Entry<VertexNode<Vertex>, Double> entry : v.getAdjacentVertices().entrySet()) {
                relax(entry, v, pq);
            }
        }
    }

    @Override
    public void search(Graph_class<Vertex> graph, Vertex source) {
        // No implementation needed for MyGraph in this context
    }

    private void relax(Map.Entry<VertexNode<Vertex>, Double> entry, VertexNode<Vertex> v, PriorityQueue<VertexNode<Vertex>> pq) {
        VertexNode<Vertex> w = entry.getKey();
        double weight = entry.getValue();
        double distToW = distTo.getOrDefault(w.getData(), Double.POSITIVE_INFINITY);
        double distToV = distTo.get(v.getData());

        if (distToW > distToV + weight) {
            distTo.put(w.getData(), distToV + weight);
            edgeTo.put(w.getData(), v.getData());
            pq.remove(w);  // Remove the element if it exists to update its position
            pq.add(w);
        }
    }

    public double distTo(Vertex v) {
        return distTo.getOrDefault(v, Double.POSITIVE_INFINITY);
    }
}
