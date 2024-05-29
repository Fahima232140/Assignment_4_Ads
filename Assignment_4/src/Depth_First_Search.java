public class Depth_First_Search<Vertex> extends Search<Vertex> {
    public Depth_First_Search(Graph_class<Vertex> graph, Vertex source) {
        super(source);
        search(graph, source);
    }

    @Override
    public void search(WeightedGraph<Vertex> graph, Vertex source) {

    }

    @Override
    public void search(Graph_class<Vertex> graph, Vertex source) {
        dfs(graph, source);
    }

    private void dfs(Graph_class<Vertex> graph, Vertex v) {
        mark(v);
        for (Vertex w : graph.adjacencyList(v)) {
            if (!hasPathTo(w)) {
                setEdge(w, v);
                dfs(graph, w);
            }
        }
    }
}
