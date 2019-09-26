package com.practice.Chapter_11_Hash_Tables.quadraticProbing

import kotlin.math.pow

class HashTable(private val arraySize: Int) {
    private val hashArray = arrayOfNulls<DataItem>(arraySize)
    private val nonItem = DataItem(-1)

    fun displayTable() {
        hashArray.forEach {
            if (it != null) print("${it.iData} ") else print("** ")
        }
        print("")
    }

    private fun hash(key: Int) = key % arraySize
    private fun quadraticProbing(key: Int, index: Int) = key + index.toDouble().pow(2).toInt()

    fun insert(item: DataItem) {
        var hashVal = hash(item.iData)
        var stepSize = 0
        var i = 0

        while (hashArray[hashVal] != null && hashArray[hashVal]?.iData != -1) {
            stepSize = quadraticProbing(item.iData, i++)
            hashVal += stepSize
            hashVal %= arraySize
        }
        hashArray[hashVal] = item
    }

    fun delete(key: Int): DataItem? {
        var hashVal = hash(key)

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal]?.iData == key) {
                val temp = hashArray[hashVal]
                hashArray[hashVal] = nonItem
                return temp
            }
            ++hashVal
            hashVal %= arraySize
        }
        return null
    }

    fun find(key: Int): DataItem? {
        var hashVal = hash(key)
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal]?.iData == key) {
                return hashArray[hashVal]
            }
            ++hashVal
            hashVal %= arraySize
        }
        return null
    }
}