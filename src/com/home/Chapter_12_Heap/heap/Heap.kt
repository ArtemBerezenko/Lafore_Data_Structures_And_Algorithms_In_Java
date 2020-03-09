package com.home.Chapter_12_Heap.heap

class Heap(val maxSize: Int) {
    private val heapArray = arrayOfNulls<Node>(maxSize)
    private var currentSize = 0

    fun isEmpty(): Boolean = currentSize == 0

    fun insert(key: Int): Boolean {
        if (currentSize == maxSize)
            return false
        val newNode = Node(key)
        heapArray[currentSize] = newNode
        trickleUp(currentSize++)
        return true
    }

    private fun trickleUp(index: Int) {
        var i = index
        var parent = (i - 1) / 2
        val bottom = heapArray[i]

        while (i > 0 && heapArray[parent]!!.key < bottom!!.key) {

            heapArray[i] = heapArray[parent]
            i = parent
            parent = (parent - 1) / 2
        }
        heapArray[i] = bottom
    }

    fun remove(): Node? {
        val root = heapArray[0]
        heapArray[0] = heapArray[--currentSize]
        trickleDown(0)
        return root
    }

    private fun trickleDown(index: Int) {
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

    fun change(index: Int, newValue: Int): Boolean {

        if (index < 0 || index >= currentSize)

            return false

        val oldValue = heapArray[index]?.key

        heapArray[index]?.key = newValue


        if (oldValue!! < newValue)
            trickleUp(index)
        else
            trickleDown(index)
        return true
    }

    fun displayHeap() {
        print("heapArray: ")
        for (m in 0 until currentSize)
            if (heapArray[m] != null)
                print("${heapArray[m]?.key} ")
            else
                print("-- ")

        println()
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
        println("\n" + dots + dots) // dotted bottom line

    }

}