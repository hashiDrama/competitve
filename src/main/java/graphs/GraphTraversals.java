package graphs;

import java.util.HashMap;
import java.util.Map;

public class GraphTraversals {

  private Map<Vertex, Boolean> visited;

  GraphTraversals(Graph graph) {
    this.visited = new HashMap<>();
    for(Vertex v: graph.getVertices()) {
      this.visited.put(v, false);
    }
  }

  public void dfs(Vertex v) {
    visited.put(v, true);
    for(Vertex u : v.getAdjList()) {
      if(!visited.get(u)) {dfs(u);}
    }
    System.out.print(v.getData() + " ");
  }
}
