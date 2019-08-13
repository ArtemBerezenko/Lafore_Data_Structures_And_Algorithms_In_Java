package com.home.Chapter_11_Hash_Tables.hash

import java.io.BufferedReader
import java.io.InputStreamReader


fun main(args: Array<String>) {
    var aDataItem: DataItem?
    var aKey: Int
    val keysPerCell = 10

    print("Enter size of hash table: ")
    val size = getInt()
    print("Enter initial number of items: ")
    val n = getInt()
    val hashTable = HashTable(size)
    for (i in 0 .. n) {
        aKey = (Math.random() * keysPerCell * size).toInt()
        aDataItem = DataItem(aKey)
        hashTable.insert(aDataItem)
    }
    while (true) {
        print("Enter first letter of ")
        print("show, insert, delete, or find: ")
        val choice = getChar()
        when (choice) {
            's' -> {
                hashTable.displayTable()
                println()
            }
            'i' -> {
                print("Enter key value to insert: ")
                aKey = getInt()
                aDataItem = DataItem(aKey)
                hashTable.insert(aDataItem)
                println()
            }
            'd' -> {
                print("Enter key value to delete: ")
                aKey = getInt()
                hashTable.delete(aKey)
            }
            'f' -> {
                print("Enter key value to find: ")
                aKey = getInt()
                aDataItem = hashTable.find(aKey)
                if (aDataItem != null) print("Found $aKey") else print("Could not find $aKey")
                println()
            }
            else -> {
                print("Invalid entry")
                println()
            }
        }
    }
}

fun getString(): String = BufferedReader(InputStreamReader(System.`in`)).readLine()
fun getInt() = Integer.parseInt(getString())
fun getChar() = getString().toCharArray().first()