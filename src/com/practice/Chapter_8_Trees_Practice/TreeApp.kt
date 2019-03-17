package com.practice.Chapter_8_Trees_Practice

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {

    val map = mapOf(Pair("c", 3), Pair("b", 2), Pair("d", 1))
    val sorted = map.toSortedMap()
    map.containsValue(3)
    println(sorted.keys) // [b, c, d]
    println(sorted.values) // [2, 3, 1]



    val theTree = Tree()
    theTree.insert(50, 1.5)
    theTree.insert(25, 1.2)
    theTree.insert(75, 1.7)
    theTree.insert(12, 1.5)
    theTree.insert(37, 1.2)
    theTree.insert(43, 1.7)
    theTree.insert(30, 1.5)
    theTree.insert(33, 1.2)
    theTree.insert(87, 1.7)
    theTree.insert(93, 1.5)
    theTree.insert(97, 1.5)

    while (true) {
        print("Enter first letter of show: ")
        print("insert, find, delete, or traverse: ")
        val choice = getChar()
        when (choice) {
            's' -> theTree.displayTree()
            'i' -> {
                print("Enter value to insert: ")
                val value = getInt()
                theTree.insert(value, value + 0.9)
            }
            'f' -> {
                print("Enter value to find: ")
                val value = getInt()
                val found = theTree.find(value)
                if (found != null) {
                    print("Found: ")
                    found.displayNode()
                    print("\n")
                }
            }

        }
    }
}

fun getString(): String  = BufferedReader(InputStreamReader(System.`in`)).readLine()

fun getChar(): Char = getString().first()

fun getInt(): Int = Integer.parseInt(getString())
