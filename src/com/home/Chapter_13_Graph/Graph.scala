package com.home.Chapter_13_Graph

import scala.util.control.Breaks._


class Graph {
  final val MAX_VERTS = 20
  val vertexList = new Array[Vertex](MAX_VERTS)
  val adjMat: Array[Array[Int]] = Array.ofDim[Int](MAX_VERTS, MAX_VERTS)
  var nVerts = 0
  val stack = new StackX
  val queue = new Queue
  val sortedArray = new Array[Char](MAX_VERTS)

  for (i <- 0 until MAX_VERTS) {
    for (j <- 0 until MAX_VERTS) {
      adjMat(i)(j) = 0
    }
  }

  def addVertex(lab: Char): Unit = {
    vertexList(nVerts) = Vertex(label = lab)
    nVerts += 1
  }

  def addEdge(start: Int, end: Int): Unit = {
    adjMat(start)(end) = 1
//    adjMat(end)(start) = 1
  }

  def displayVertex(v: Int): Unit = print(vertexList(v).label)

  def dfs(): Unit = {
    vertexList(0).wasVisited = true
    displayVertex(0)
    stack.push(0)

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

  def mst(): Unit = {
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

  private def getAdjUnvisitedVertex(v: Int): Int = {
    for (i <- 0 until nVerts) {
      if (adjMat(v)(i) == 1 && !vertexList(i).wasVisited) return i
    }
    -1
  }


  def topo(): Unit = {
    val orig_nVerts = nVerts

    while (nVerts > 0) {
      val currentVertex = noSuccessors()
      if (currentVertex == -1) {
        println("ERROR: Graph has cycles")
        return
      }
      sortedArray(nVerts - 1) = vertexList(currentVertex).label
      deleteVertex(currentVertex)
    }
    print("Topologically sorted order: ")
    for (i <- 0 until orig_nVerts) {
      print(sortedArray(i))
    }
    println("")
  }

  def noSuccessors(): Int = {
    var isEdge = false

    for (i <- 0 until nVerts) {
      isEdge = false
      breakable {
        for (j <- 0 until nVerts) {
          if (adjMat(i)(j) > 0) {
            isEdge = true
            break
          }
        }
      }
      if (!isEdge) return i
    }
    -1
  }

  def deleteVertex(v: Int): Unit = {
    if (v != nVerts - 1) {
      for (i <- v until nVerts - 1) {
        vertexList(i) = vertexList(i + 1)
      }
      for (i <- v until nVerts - 1) {
        moveRowUp(i, nVerts)
      }

      for (i <- v until nVerts - 1) {
        moveColLeft(i, nVerts - 1)
      }
    }
    nVerts -= 1
  }

  def moveRowUp(row: Int, length: Int): Unit = {
    for (i <- 0 until length) {
      adjMat(row)(i) = adjMat(row + 1)(i)
    }
  }

  def moveColLeft(column: Int, length: Int): Unit = {
    for (i <- 0 until length) {
      adjMat(i)(column) = adjMat(i)(column +1)
    }
  }

}
