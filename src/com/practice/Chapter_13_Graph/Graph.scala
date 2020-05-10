package com.practice.Chapter_13_Graph


import scala.util.control.Breaks._


class Graph {
  final val MAX_VERTS = 20
  val vertexList = new Array[Vertex](MAX_VERTS)
//  val adjMat: Array[Array[Int]] = Array.ofDim[Int](MAX_VERTS, MAX_VERTS)
  val adjList: Array[LinkList] = new Array[LinkList](MAX_VERTS)
  var nVerts = 0
  val stack = new StackX
  val queue = new Queue
  val sortedArray = new Array[Char](MAX_VERTS)

  for (i <- 0 until MAX_VERTS) {
    adjList(i) = new LinkList
  }

  def addVertex(lab: Char): Unit = {
    vertexList(nVerts) = Vertex(label = lab)
    nVerts += 1
  }

  def addEdge(start: Int, end: Int): Unit = adjList(start).insert(end)


  def displayVertex(v: Int): Unit = print(vertexList(v).label)

  def dfs(start: Int): Unit = {
    vertexList(start).wasVisited = true
    displayVertex(start)
    stack.push(start)

    while (!stack.isEmpty) {
      val v = getAdjUnvisitedVertex(stack.peek)
      if (v == -1)
        stack.pop
      else {
        vertexList(v).wasVisited = true
        displayVertex(v)
        stack.push(v)
      }
    }

    for (i <- 0 until nVerts) {
      vertexList(i).wasVisited = false
    }
  }

  def bfs(): Unit = {
    vertexList(0).wasVisited = true
    displayVertex(0)
    queue.insert(0)

    while (!queue.isEmpty) {
      val v1 = queue.remove()
      var v2 = getAdjUnvisitedVertex(v1)
      while (v2 != -1) {
        vertexList(v2).wasVisited = true
        displayVertex(v2)
        queue.insert(v2)
        v2 = getAdjUnvisitedVertex(v1)
      }
    }

    for (i <- 0 until nVerts) {
      vertexList(i).wasVisited = false
    }
  }

  def mstDfs(): Unit = {
    vertexList(0).wasVisited = true
    stack.push(0)

    while (!stack.isEmpty) {
      val currentVertex = stack.peek
      val v = getAdjUnvisitedVertex(currentVertex)
      if (v == -1) {
        stack.pop
      } else {
        vertexList(v).wasVisited = true
        stack.push(v)

        displayVertex(currentVertex)
        displayVertex(v)
        print(" ")
      }
    }

    for (i <- 0 until nVerts) {
      vertexList(i).wasVisited = false
    }
  }

  def mstBfs(): Unit = {
    vertexList(0).wasVisited = true
    queue.insert(0)

    while (!queue.isEmpty) {
      val currentVertex = queue.remove()
      var v2 = getAdjUnvisitedVertex(currentVertex)
      while (v2 != -1) {
        vertexList(v2).wasVisited = true

        displayVertex(currentVertex)
        displayVertex(v2)
        print(" ")

        queue.insert(v2)
        v2 = getAdjUnvisitedVertex(currentVertex)
      }

    }
    for (i <- 0 until nVerts) {
      vertexList(i).wasVisited = false
    }
  }

  private def getAdjUnvisitedVertex(v: Int): Int = {
    for (i <- 0 until nVerts) {
      if (adjList(v).contains(i) == 1 && !vertexList(i).wasVisited)
        return i
    }
    -1
  }

  def displayConnectivityTable(): Unit = {
    for (i <- 0 until nVerts) {
      dfs(i)
    }
  }
}


