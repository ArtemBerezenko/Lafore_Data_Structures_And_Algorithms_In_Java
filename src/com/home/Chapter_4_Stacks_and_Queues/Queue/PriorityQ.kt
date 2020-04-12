package com.home.Chapter_4_Stacks_and_Queues.Queue

class PriorityQ (val maxSize: Int) {
    val queArray = LongArray(maxSize)
    var nItems = 0

    fun insert(value: Long) {
        if (nItems == 0) {
            queArray[nItems++] = value
        } else {
            var i: Int = nItems - 1
            while (i >= 0 && value > queArray[i]) {
                queArray[i + 1] = queArray[i]
                --i
            }
            queArray[i + 1] = value
            ++nItems
        }
    }

    fun remove() = queArray[--nItems]

    fun peekMin() = queArray[nItems - 1]

    fun isEmpty() = nItems == 0

    fun isFull() = nItems == maxSize
}

fun main(args: Array<String>) {
    val queue = PriorityQ(5).apply {
        insert(30L)
        insert(50L)
        insert(10L)
        insert(40L)
        insert(20L)
    }

    while (!queue.isEmpty()) {
        val var2: Long = queue.remove()
        print("$var2 ")
    }

    println("")
}