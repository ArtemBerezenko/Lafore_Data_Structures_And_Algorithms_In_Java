package com.practice.Chapter_10_23_Trees

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.Reader

object Tree23App {

    val string: String
        @Throws(IOException::class)
        get() {
            val isr = InputStreamReader(System.`in`)
            val br = BufferedReader(isr as Reader?)
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

    private fun sort(theArray: LongArray, counter: Int) {
        val sortingTree = Tree23()
        for (j in 0 until counter)
            sortingTree.insert(theArray[j])
        println()
        sortingTree.displayTree()
        sortingTree.sortTraverse(theArray)
    }

    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        var value: Int
        val theTree = Tree23()
        with(theTree) {
            insert(60)
            insert(80)
            insert(40)
            insert(50)
            insert(70)
            insert(90)
            insert(45)
//            insert(10)
//            insert(90)
//            insert(20)
//            insert(55)
//            insert(100)
//            insert(99)
        }

        while (true) {
            print("Enter first letter of ")
            print("show, insert, minimum, traverse, order, or find: ")
            val choice = char
            when (choice) {
                's' -> theTree.displayTree()
                'i' -> {
                    print("Enter value to insert: ")
                    value = int
                    theTree.insert(value.toLong())
                }
                'm' -> {
                    val min = theTree.findMinimum()
                    print("Minimum is $min\n")
                }
                'o' -> {
                    value = 0
                    val arrayToSort = LongArray(20)
                    var counter = 0
                    while (value != -1 && counter < 20) {
                        print("Enter value (enter '-1' to stop): ")
                        value = int
                        if (value != -1) {
                            arrayToSort[counter] = value.toLong()
                            counter++
                        }
                    }
                    println("Before sorting...")
                    for (j in 0 until counter)
                        print(arrayToSort[j].toString() + " ")
                    sort(arrayToSort, counter)
                    println("After sorting...")
                    for (j in 0 until counter)
                        print(arrayToSort[j].toString() + " ")
                    println("")
                }
                't' -> {
                    theTree.traverseInOrder()
                    println("")
                }
                'f' -> {
                    print("Enter value to find: ")
                    value = int
                    val found = theTree.find(value.toLong())
                    if (found != -1)
                        println("Found $value")
                    else
                        println("Could not find $value")
                }
                else -> println("Invalid entry!")
            }//end switch
        }//end while
    }//end main()
} //end class Tree234App

