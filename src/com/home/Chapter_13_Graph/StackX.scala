package com.home.Chapter_13_Graph

class StackX {
  final val SIZE = 20
  val st = new Array[Int](SIZE)
  var top: Int = -1

  def push(i: Int): Unit = {
    top += 1
    st(top) = i
  }

  def pop: Int = {
    val v = st(top)
    top -= 1
    v
  }

  def peek: Int = st(top)

  def isEmpty: Boolean = top == -1
}
