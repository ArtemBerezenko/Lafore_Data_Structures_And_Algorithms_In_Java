package com.home.Chapter_14_Weighted_Graphs.scala

object MSTWApp {

  def main(array: Array[String]): Unit = {
    val graph = new Graph()
    graph.addVertex('A')
    graph.addVertex('B')
    graph.addVertex('C')
    graph.addVertex('D')
    graph.addVertex('E')
    graph.addVertex('F')

    graph.addEdge(0, 1, 6); // AB  6
    graph.addEdge(0, 3, 4); // AD  4
    graph.addEdge(1, 2, 10); // BC 10
    graph.addEdge(1, 3, 7); // BD  7
    graph.addEdge(1, 4, 7); // BE  7
    graph.addEdge(2, 3, 8); // CD  8
    graph.addEdge(2, 4, 5); // CE  5
    graph.addEdge(2, 5, 6); // CF  6
    graph.addEdge(3, 4, 12); // DE 12
    graph.addEdge(4, 5, 7); // EF  7

    print("Minimum spanning tree: ")
    graph.mstw()
    println()
  }
}
