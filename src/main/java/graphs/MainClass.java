package graphs;

public class MainClass {

  public static void main(String[] args) {
    Graph graph = new Graph();
    Vertex a = new Vertex("A");
    Vertex b = new Vertex("B");
    Vertex c = new Vertex("C");
    Vertex d = new Vertex("D");
    Vertex e = new Vertex("E");
    Vertex f = new Vertex("F");
    
    graph.addVertex(a);
    graph.addVertex(b);
    graph.addVertex(c);
    graph.addVertex(d);
    graph.addVertex(e);
    graph.addVertex(f);
    
    graph.addEdge(a, b);
    graph.addEdge(a, d);
    graph.addEdge(c, b);
    graph.addEdge(e, b);
    graph.addEdge(e, f);
    
    GraphTraversals traverse = new GraphTraversals(graph);
    traverse.dfs(graph.getVertices().get(0));
  }
}
