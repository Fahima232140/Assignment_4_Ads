import java.util.*;

public abstract class Search<Vertex> {
    protected final Vertex source;
    protected final Map<Vertex, Boolean> marked;
    protected final Map<Vertex, Vertex> edgeTo;

    public Search(Vertex source) {
        this.source = source;
        this.marked = new HashMap<>();
        this.edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex v) {
        return marked.getOrDefault(v, false);
    }

    public Iterable<Vertex> pathTo(Vertex v) {
        if (!hasPathTo(v)) return null;
        LinkedList<Vertex> path = new LinkedList<>();
        for (Vertex x = v; !x.equals(source); x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        path.addFirst(source);
        return path;
    }

    protected void mark(Vertex v) {
        marked.put(v, true);
    }

    protected void setEdge(Vertex v, Vertex w) {
        edgeTo.put(v, w);
    }

    public abstract void search(WeightedGraph<Vertex> graph, Vertex source);

    public abstract void search(Graph_class<Vertex> graph, Vertex source);
}
