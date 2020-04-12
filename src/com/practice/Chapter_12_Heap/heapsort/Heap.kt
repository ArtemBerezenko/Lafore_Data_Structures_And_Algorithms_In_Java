package com.practice.Chapter_12_Heap.heapsort

data class Node(var key: Int)

class Heap(val maxSize: Int) {
    private val heapArray = arrayOfNulls<Node>(maxSize)
    private var currentSize = 0

    fun remove(): Node? {
        val root = heapArray[0]
        heapArray[0] = heapArray[--currentSize]
        trickleDown(0)
        return root
    }

    fun trickleDown(index: Int) {
        var i = index
        var largerChild: Int
        val top = heapArray[i]

        while (i < currentSize / 2) {
            val leftChild = 2 * i + 1
            val rightChild = leftChild + 1
            largerChild = if ((rightChild < currentSize &&
                            heapArray[leftChild]!!.key < heapArray[rightChild]!!.key))
                rightChild
            else
                leftChild

            if (top!!.key >= heapArray[largerChild]!!.key)
                break
            heapArray[i] = heapArray[largerChild]
            i = largerChild
        }
        heapArray[i] = top
    }

    fun displayHeap() {
        var nBlanks = 32
        var itemsPerRow = 1
        var column = 0
        var j = 0
        val dots = "..............................."
        println(dots + dots)

        while (currentSize > 0) {
            if (column == 0)
                for (k in 0 until nBlanks)
                    print(' ')
            print(heapArray[j]?.key)

            if (++j == currentSize)
                break

            if (++column == itemsPerRow) {
                nBlanks /= 2
                itemsPerRow *= 2
                column = 0
                println()
            } else
                for (k in 0 until nBlanks * 2 - 2)
                    print(' ')

        }
        println("\n" + dots + dots)
    }

    fun displayArray() {
        for (i in 0 until maxSize) {
            print("${heapArray[i]?.key} ")
        }
        println("")
    }

    fun insertAt(index: Int, newNode: Node) {
        heapArray[index] = newNode
    }

    fun incrementSize() {
        currentSize++
    }

}