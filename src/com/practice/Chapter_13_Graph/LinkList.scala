package com.practice.Chapter_13_Graph


class LinkList {
  val head: Link = Link()

  def insert(v: Int): Unit = {
    var cur = head
    while ( {
      cur.next != null
    }) cur = cur.next
    cur.next = Link(v, null)
  }

  def contains(i: Int): Boolean = {
    var cur = head
    while (cur != null) {
      if (cur.vertex == i) return true
      cur = cur.next
    }
    false
  }
}
