package com.practice.Chapter_11_Hash_Tables.stringHashing

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    var aDataItem: DataItem?
    var aKey: String

    print("Enter size of hash table: ")
    val size = getInt()
    print("Enter initial number of items: ")
    val n = getInt()
    val hashTable = HashTable(size)
    for (i in 0 .. n) {
        val wordLength = (1..5).shuffled().first()
        aDataItem = DataItem(randomAlphaNumeric(wordLength))
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
                aKey = getString()
                aDataItem = DataItem(aKey)
                hashTable.insert(aDataItem)
                println()
            }
            'd' -> {
                print("Enter key value to delete: ")
                aKey = getString()
                hashTable.delete(aKey)
            }
            'f' -> {
                print("Enter key value to find: ")
                aKey = getString()
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


private val ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"

fun randomAlphaNumeric(count: Int): String {
    var count = count
    val builder = StringBuilder()
    while (count-- != 0) {
        val character = (Math.random() * ALPHA_NUMERIC_STRING.length).toInt()
        builder.append(ALPHA_NUMERIC_STRING[character])
    }
    return builder.toString()
}