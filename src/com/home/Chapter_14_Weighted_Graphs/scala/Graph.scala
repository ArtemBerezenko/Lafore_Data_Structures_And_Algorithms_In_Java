package com.home.Chapter_14_Weighted_Graphs.scala

import scala.util.control.Breaks._

class Graph {
  private val MAX_VERTS = 20
  private val INFINITY = 1000000
  private val vertexList = new Array[Vertex](MAX_VERTS)
  private val adjMat: Array[Array[Int]] = Array.ofDim(MAX_VERTS, MAX_VERTS)
  private var nVerts = 0
  private var currentVert = 0
  private val pq: PriorityQ = new PriorityQ()
  private var nTree = 0


  for (i <- 0 until MAX_VERTS) {
    for (k <- 0 until MAX_VERTS) {
      adjMat(i)(k) = INFINITY
    }
  }

  def addVertex(lab: Char): Unit = {
    vertexList(nVerts) = Vertex(lab)
    nVerts += 1
  }

  def addEdge(start: Int, end: Int, weight: Int): Unit = {
    adjMat(start)(end) = weight
    adjMat(end)(start) = weight
  }

  def displayVertex(v: Int): Unit = {
    print(vertexList(v).label)
  }

  def mstw(): Unit = {
    currentVert = 0

    while (nTree < nVerts - 1) {
      vertexList(currentVert).isInTree = true
      nTree += 1

      for (i <- 0 until nVerts) {
        breakable {
          if (i == currentVert) break
          if (vertexList(i).isInTree) break
          val distance = adjMat(currentVert)(i)
          if (distance == INFINITY) break
          putInPQ(i, distance)
        }
      }

      if (pq.size == 0) {
        println(" GRAPH NOT CONNECTED")
        return
      }

      val edge: Edge = pq.removeMin()
      val sourceVert = edge.srcVert
      currentVert = edge.destVert

      print(vertexList(sourceVert).label)
      print(vertexList(currentVert).label)
      print(" ")
    }

    for (i <- 0 until nVerts) {
      vertexList(i).isInTree = false
    }

  }

  def putInPQ(newVert: Int, newDist: Int): Unit = {
    val queueIndex = pq.find(newVert)
    if (queueIndex != -1) {
      val tempEdge = pq.peekN(queueIndex)
      val oldDist = tempEdge.distance
      if (oldDist > newDist) {
        pq.removeN(queueIndex)
        val edge = Edge(currentVert, newVert, newDist)
        pq.insert(edge)
      }
    } else {
      val edge = Edge(currentVert, newVert, newDist)
      pq.insert(edge)
    }
  }


}
