package com.practice.Chapter_13_Graph

object DFSApp {

  def main(args: Array[String]): Unit = {
    val graph = new Graph
    graph.addVertex('A')
    graph.addVertex('B')
    graph.addVertex('C')
    graph.addVertex('D')
    graph.addVertex('E')

    graph.addEdge(0, 1)
    graph.addEdge(2, 1)
    graph.addEdge(2, 3)
    graph.addEdge(3, 1)
    graph.addEdge(4, 2)

    graph.displayConnectivityTable()
  }
}
