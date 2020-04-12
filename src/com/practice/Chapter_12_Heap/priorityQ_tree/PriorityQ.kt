package com.practice.Chapter_12_Heap.priorityQ_tree

class PriorityQTree {
    val tree: Tree = Tree()
    private var nItems = 0

    fun insert(value: Int, payload: Double) {
        tree.insert(value, payload)
        nItems++
    }

    fun remove(): Int? {
        val maximum = tree.maximum().iData
        if (maximum != null) {
            tree.delete(maximum)
        }
        nItems--
        return maximum
    }

    fun isEmpty() = nItems == 0
}

fun main(args: Array<String>) {
    val queue = PriorityQTree().apply {
        insert(50, 1.5)
        insert(25, 1.2)
        insert(75, 1.7)
        insert(12, 1.5)
        insert(37, 1.2)
        insert(43, 1.7)
        insert(30, 1.5)
        insert(33, 1.2)
        insert(87, 1.7)
        insert(93, 1.5)
        insert(97, 1.5)
    }

    queue.tree.displayTree()

    while (!queue.isEmpty()) {
        val value = queue.remove()
        print("$value ")
    }

    println("")
}