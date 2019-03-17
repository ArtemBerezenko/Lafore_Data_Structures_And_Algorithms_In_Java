package com.home.Chapter_9_234_Trees

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    var value: Int
    val tree = Tree234()

    tree.insert(50)
    tree.insert(40)
    tree.insert(60)
    tree.insert(30)
    tree.insert(70)

    while (true) {
        print("Enter first letter of ")
        print("show, insert, or find: ")
        val choice = getChar()
        when(choice) {
            's' -> tree.displayTree()
            'i' -> {
                print("Enter value to insert: ")
                value = getInt()
                tree.insert(value)
            }
            'f' -> {
                print("Enter value to find: ")
                value = getInt()
                val found = tree.find(value)
                if (found != -1) print("Found $value\n") else print("Could't find $value\n")
            }
            else -> print("Invalid entry\n")
        }
    }

}

fun getInt(): Int = getString().toInt()

fun getChar() = getString().first()

fun getString(): String = BufferedReader(InputStreamReader(System.`in`)).readLine()
