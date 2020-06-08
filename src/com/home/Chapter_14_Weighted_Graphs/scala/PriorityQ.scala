package com.home.Chapter_14_Weighted_Graphs.scala

import scala.util.control.Breaks._

class PriorityQ {
  private val SIZE = 20
  val queArray = new Array[Edge](SIZE)
  var size = 0

  def insert(item: Edge): Unit = {
    var k = 0
    breakable {
      for (i <- 0 until size) {
        k = i
        if (item.distance >= queArray(i).distance) {
          break
        }
      }
    }

    for (i <- size - 1 to k by -1) {
      queArray(i + 1) = queArray(i)
    }

    queArray(k) = item
    size += 1
  }

  def removeMin(): Edge = {
    size -= 1
    queArray(size)
  }

  def removeN(n: Int): Unit = {
    for (i <- n until size - 1) {
      queArray(i) = queArray(i + 1)
    }
    size -= 1
  }

  def peekMin(): Edge = queArray(size - 1)

  def isEmpty: Boolean = size == 0

  def peekN(n: Int): Edge = queArray(n)

  def find(findDex: Int): Int = {
    for (i <- 0 until size) {
      if (queArray(i).destVert == findDex) {
        return i
      }
    }
    -1
  }

}
