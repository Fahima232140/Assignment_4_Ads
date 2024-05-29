import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WeightedGraph<Vertex> {
    private final boolean undirected;
    private Map<Vertex, VertexNode<Vertex>> vertices;

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
        this.vertices = new HashMap<>();
    }

    public void addVertex(Vertex data) {
        vertices.putIfAbsent(data, new VertexNode<>(data));
    }

    public void addEdge(Vertex source, Vertex destination, double weight) {
        VertexNode<Vertex> sourceVertex = vertices.get(source);
        VertexNode<Vertex> destinationVertex = vertices.get(destination);
        if (sourceVertex != null && destinationVertex != null) {
            sourceVertex.addAdjacentVertex(destinationVertex, weight);
            if (undirected) {
                destinationVertex.addAdjacentVertex(sourceVertex, weight);
            }
        }
    }

    public VertexNode<Vertex> getVertex(Vertex data) {
        return vertices.get(data);
    }

    public Map<Vertex, VertexNode<Vertex>> getVertices() {
        return vertices;
    }

    public int getVerticesCount() {
        return vertices.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (VertexNode<Vertex> v : vertices.values()) {
            count += v.getAdjacentVertices().size();
        }
        if (undirected) count /= 2;
        return count;
    }

    public boolean hasVertex(Vertex v) {
        return vertices.containsKey(v);
    }

    public boolean hasEdge(Vertex source, Vertex dest) {
        VertexNode<Vertex> sourceVertex = vertices.get(source);
        VertexNode<Vertex> destVertex = vertices.get(dest);
        return sourceVertex != null && destVertex != null && sourceVertex.getAdjacentVertices().containsKey(destVertex);
    }

    public List<Vertex> adjacencyList(Vertex v) {
        VertexNode<Vertex> vertex = vertices.get(v);
        if (vertex == null) return null;
        List<Vertex> adjacentVertices = new LinkedList<>();
        for (VertexNode<Vertex> adjacent : vertex.getAdjacentVertices().keySet()) {
            adjacentVertices.add(adjacent.getData());
        }
        return adjacentVertices;
    }

    public Iterable<Map.Entry<VertexNode<Vertex>, Double>> getEdges(Vertex v) {
        VertexNode<Vertex> vertex = vertices.get(v);
        if (vertex == null) return null;
        return vertex.getAdjacentVertices().entrySet();
    }
}

class VertexNode<Vertex> {
    private Vertex data;
    private Map<VertexNode<Vertex>, Double> adjacentVertices;

    public VertexNode(Vertex data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    public Vertex getData() {
        return data;
    }

    public void addAdjacentVertex(VertexNode<Vertex> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    public Map<VertexNode<Vertex>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }
}
