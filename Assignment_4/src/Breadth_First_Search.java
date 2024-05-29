import java.util.*;

public class Breadth_First_Search<Vertex> extends Search<Vertex> {
    public Breadth_First_Search(Graph_class<Vertex> graph, Vertex source) {
        super(source);
        search(graph, source);
    }


    @Override
    public void search(WeightedGraph<Vertex> graph, Vertex source) {

    }

    @Override
    public void search(Graph_class<Vertex> graph, Vertex source) {
        Queue<Vertex> queue = new LinkedList<>();
        mark(source);
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            for (Vertex w : graph.adjacencyList(v)) {
                if (!hasPathTo(w)) {
                    mark(w);
                    setEdge(w, v);
                    queue.add(w);
                }
            }
        }
    }
}
