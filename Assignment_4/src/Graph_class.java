import java.util.*;

public class Graph_class<Vertex> {
    private final boolean undirected;
    private final Map<Vertex, List<Vertex>> adjList;

    public Graph_class() {
        this(true);
    }

    public Graph_class(boolean undirected) {
        this.undirected = undirected;
        this.adjList = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        if (hasVertex(v))
            return;

        adjList.put(v, new LinkedList<>());
    }

    public void addEdge(Vertex source, Vertex dest) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest) || source.equals(dest))
            return; // reject parallels & self-loops

        adjList.get(source).add(dest);

        if (undirected)
            adjList.get(dest).add(source);
    }

    public int getVerticesCount() {
        return adjList.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (Vertex v : adjList.keySet()) {
            count += adjList.get(v).size();
        }

        if (undirected)
            count /= 2;

        return count;
    }

    public boolean hasVertex(Vertex v) {
        return adjList.containsKey(v);
    }

    public boolean hasEdge(Vertex source, Vertex dest) {
        if (!hasVertex(source)) return false;
        return adjList.get(source).contains(dest);
    }

    public List<Vertex> adjacencyList(Vertex v) {
        if (!hasVertex(v)) return null;

        return adjList.get(v);
    }
}
