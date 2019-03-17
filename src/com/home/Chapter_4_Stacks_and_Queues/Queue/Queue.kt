package com.home.Chapter_4_Stacks_and_Queues.Queue

class Queue (val size: Int) {
    val maxSize = size + 1
    val queArray = LongArray(maxSize)
    var front: Int = 0
    var rear = -1

    fun insert(value: Long) {
        if (rear == maxSize - 1) {
            rear = -1
        }
        queArray[++rear] = value
    }

    fun remove(): Long {
        val temp = queArray[front++]
        if (front == maxSize) {
            front = 0
        }
        return temp
    }

    fun peek() = queArray[front]

    fun isEmpty() = (rear + 1 == front) || (front + maxSize - 1 == rear)
    fun isFull() = (rear + 2 == front) || (front + maxSize - 2 == rear)
    fun size() = if (rear >= front) rear - front + 1 else maxSize - front + rear + 1
}

fun main(args: Array<String>) {
    val queue = Queue(5)
    queue.insert(10)
    queue.insert(20)
    queue.insert(30)
    queue.insert(40)

    queue.remove()
    queue.remove()
    queue.remove()

    queue.insert(50)
    queue.insert(60)
    queue.insert(70)
    queue.insert(80)

    if (queue.isFull()) {
        print("Help!")
    }

    while (!queue.isEmpty()) {
        val n = queue.remove()
        print(n)
        print("")
    }
    println("")
}