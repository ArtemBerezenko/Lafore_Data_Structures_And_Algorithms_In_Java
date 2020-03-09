package com.home.Chapter_12_Heap.heap

import java.io.IOException
import java.io.BufferedReader
import java.io.InputStreamReader


internal object HeapApp {

    val string: String
        @Throws(IOException::class)
        get() {

            val isr = InputStreamReader(System.`in`)

            val br = BufferedReader(isr)

            return br.readLine()

        }

    val char: Char
        @Throws(IOException::class)
        get() {

            val s = string

            return s[0]

        }

    val int: Int
        @Throws(IOException::class)
        get() {

            val s = string

            return Integer.parseInt(s)

        }

    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {

        var value: Int
        var value2: Int
        val theHeap = Heap(31)
        var success: Boolean

        with(theHeap) {
            insert(70)
            insert(40)
            insert(50)
            insert(20)
            insert(60)
            insert(100)
            insert(80)
            insert(30)
            insert(10)
            insert(90)
        }

        while (true) {

            print("Enter first letter of ")

            print("show, insert, remove, change: ")

            when (char) {

                's' -> theHeap.displayHeap()

                'i' -> {
                    print("Enter value to insert: ")
                    value = int
                    success = theHeap.insert(value)
                    if (!success)
                        println("Can't insert; heap full")
                }

                'r' ->
                    if (!theHeap.isEmpty())
                        theHeap.remove()
                    else
                        println("Can't remove; heap empty")
                'c' -> {
                    print("Enter current index of item: ")
                    value = int
                    print("Enter new key: ")
                    value2 = int
                    success = theHeap.change(value, value2)
                    if (!success)
                        println("Invalid index")
                }
                else -> println("Invalid entry\n")
            }

        }

    }
}
