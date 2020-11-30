package graphs;

public class DisjointSetDataStructure {

  int forests;
  int[] parent;
  int[] rank;

  public DisjointSetDataStructure(int n) {
    this.forests = n;
    this.parent = new int[this.forests];
    this.rank = new int[this.forests];
    for (int i = 0; i < this.forests; i++) {
      parent[i] = i;
      rank[i] = 1;
    }
  }

  public int find(int i) {
    if (this.parent[i] == i)
      return i;
    int rep = find(parent[i]);
    this.parent[i] = rep;
    return rep;
  }

  public boolean union(int i, int j) {
    int irep = this.find(i);
    int jrep = this.find(j);
    if (irep == jrep)
      return false;
    int irank = rank[irep];
    int jrank = rank[jrep];
    if (irank > jrank)
      this.parent[jrep] = irep;
    else if (irank < jrank)
      this.parent[irep] = jrep;
    else {
      this.parent[irep] = jrep;
      rank[jrep]++;
    }
    return true;
  }
}
