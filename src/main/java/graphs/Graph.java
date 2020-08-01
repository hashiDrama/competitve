package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Adjacency list representation of undirected graph.
 * 
 */
public class Graph {

  private List<Vertex> vertices;

  public Graph() {
    this.vertices = new ArrayList<>();
  }

  public List<Vertex> getVertices() {
    return this.vertices;
  }

  public void addVertex(Vertex v) {
    if (this.vertices.contains(v)) {
      System.out.println("Vertex already exists.");
      return;
    }
    this.vertices.add(v);
  }

  public void addEdge(Vertex v1, Vertex v2) {
    if (!vertices.contains(v1) || !vertices.contains(v2)) {
      System.out.println(
          "Vertices not present in graph\n" + "Please first add them using addVertex(Vertex v)");
      return;
    }
    if (isEdge(v1, v2)) {
      System.out.println("Edge already exists b/w " + v1.getData() + " and " + v2.getData());
      return;
    }
    v1.getAdjList().add(v2);
    v2.getAdjList().add(v1);
    System.out.println("Edge added b/w " + v1.getData() + " and " + v2.getData());
  }

  public boolean isEdge(Vertex v1, Vertex v2) {
    if (v1.getAdjList().contains(v2) || v2.getAdjList().contains(v1)) {
      return true;
    }
    return false;
  }

  public void removeEdge(Vertex v1, Vertex v2) {
    if (!isEdge(v1, v2)) {
      System.out
          .println("Edge between " + v1.getData() + " and " + v2.getData() + " does not exists.");
      return;
    }
    v1.getAdjList().remove(v2);
    v2.getAdjList().remove(v1);
    System.out
        .println("Edge between " + v1.getData() + " and " + v2.getData() + " has been removed.");
  }

  public void removeVertex(Vertex v) {
    if (!this.vertices.contains(v)) {
      System.out.println("Vertex " + v.getData() + " does not exists in current graph.");
      return;
    }
    for (Vertex u : this.vertices) {
      if (!u.getData().equals(v.getData())) {
        removeEdge(v, u);
      }
    }
    this.vertices.remove(v);
    System.out.println("Vertex " + v.getData() + " has been removed.");
  }
}
