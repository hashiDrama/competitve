package com.competitive.graphs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

  private String data;
  private Vertex next;
  private List<Vertex> adjList;

  public Vertex(String data) {
    this.data = data;
    this.next = null;
    this.adjList = new ArrayList<>();
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public Vertex getNext() {
    return next;
  }

  public void setNext(Vertex next) {
    this.next = next;
  }

  public List<Vertex> getAdjList() {
    return adjList;
  }

  public void setAdjList(List<Vertex> adjList) {
    this.adjList = adjList;
  }

}
