package com.practice.Chapter_12_Heap.priorityQ_heap

class PriorityQ (val maxSize: Int) {
    val heap: Heap = Heap(maxSize)
    var nItems = 0

    fun insert(value: Int) {
        heap.insert(value)
        nItems++
    }

    fun remove(): Int? {
        nItems--
        return heap.remove()?.key
    }

    fun peekMin() = heap.getLast()

    fun isEmpty() = nItems == 0

    fun isFull() = nItems == maxSize
}

fun main(args: Array<String>) {
    val queue = PriorityQ(5).apply {
        insert(30)
        insert(50)
        insert(10)
        insert(40)
        insert(20)
    }

    queue.heap.displayHeap()

    while (!queue.isEmpty()) {
        val value = queue.remove()
        print("$value ")
    }

    println("")
}