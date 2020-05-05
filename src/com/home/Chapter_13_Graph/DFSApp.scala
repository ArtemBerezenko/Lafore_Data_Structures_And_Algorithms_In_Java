package com.home.Chapter_13_Graph

object DFSApp {

  def main(args: Array[String]): Unit = {
    val graph = new Graph
    graph.addVertex('A')
    graph.addVertex('B')
    graph.addVertex('C')
    graph.addVertex('D')
    graph.addVertex('E')
    graph.addVertex('F')
    graph.addVertex('G')
    graph.addVertex('H')


    graph.addEdge(0, 3);     // AD
    graph.addEdge(0, 4);     // AE
    graph.addEdge(1, 4);     // BE
    graph.addEdge(2, 5);     // CF
    graph.addEdge(3, 6);     // DG
    graph.addEdge(4, 6);     // EG
    graph.addEdge(5, 7);     // FH
    graph.addEdge(6, 7);     // GH

//    print("Visits: ")
//    graph.dfs()
//    println()
//    graph.bfs()
//    println()
//    graph.mst()
//    println()
    graph.topo()
  }
}
