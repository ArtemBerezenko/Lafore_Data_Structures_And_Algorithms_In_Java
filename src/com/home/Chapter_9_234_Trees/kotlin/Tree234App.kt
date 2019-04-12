package com.home.Chapter_9_234_Trees.kotlin

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

object Tree234App {

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

    //Exercise 3: Sort array with tree
    fun sort(theArray: LongArray, counter: Int) {
        val sortingTree = Tree234()
        //insert all values into the tree
        for (j in 0 until counter)
            sortingTree.insert(theArray[j])
        sortingTree.sortTraverse(theArray)
    }

    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        var value: Int
        val theTree = Tree234()

        theTree.insert(50)
        theTree.insert(40)
        theTree.insert(60)
        theTree.insert(30)
        theTree.insert(70)

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
                'm' -> theTree.findMinimum()
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
                't' -> theTree.traverseInOrder()
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

