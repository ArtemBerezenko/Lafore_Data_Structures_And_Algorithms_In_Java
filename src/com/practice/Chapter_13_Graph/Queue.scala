package com.practice.Chapter_13_Graph

class Queue {
  final val SIZE = 20
  val queueArray = new Array[Int](SIZE)
  var front: Int = 0
  var rear: Int = -1

  def insert(i: Int): Unit = {
    if (rear == SIZE - 1)
      rear = -1
    rear += 1
    queueArray(rear) = i
  }

  def remove(): Int = {
    val temp = queueArray(front)
    front += 1
    if (front == SIZE)
      front = 0
    temp
  }

  def isEmpty: Boolean = (rear + 1 == front) || (front + SIZE - 1 == rear)
}
