package com.home.Chapter_12_Heap.heapsort

import java.io.BufferedReader
import java.io.InputStreamReader

object HeapApp {

    fun getString(): String = BufferedReader(InputStreamReader(System.`in`)).readLine()

    fun getInt(): Int = Integer.parseInt(getString())
}

fun main(args: Array<String>) {
    print("Enter number of items:")
    val size = HeapApp.getInt()
    val heap = Heap(size)
    for (i in 0 until size) {
        val random = (Math.random() * 100).toInt()
        val newNode = Node(random)
        heap.insertAt(i, newNode)
        heap.incrementSize()
    }
    print("Random: ")
    heap.displayArray()

    for (i in (size/2)-1 downTo 0) {
        heap.trickleDown(i)
    }
    print("Heap: ")
    with(heap) {
        displayArray()
        displayHeap()
    }

    for (i in size - 1 downTo 0) {
        val biggestNode = heap.remove()
        biggestNode?.let {
            heap.insertAt(i, biggestNode)
        }
    }
    print("Sorted: ")
    heap.displayArray()
}
