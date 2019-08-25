package com.home.Chapter_11_Hash_Tables.hashDouble

class HashTable(private val arraySize: Int) {
    private val hashArray = arrayOfNulls<DataItem>(arraySize)
    private val nonItem = DataItem(-1)

    companion object {
        const val constant = 5
    }

    fun displayTable() {
        hashArray.forEach {
            if (it != null) print("${it.iData} ") else print("** ")
        }
        print("")
    }

    private fun hash1(key: Int) = key % arraySize

    private fun hash2(key: Int) = constant - key % constant

    fun insert(item: DataItem) {
        var hashVal = hash1(item.iData)
        val stepSize = hash2(item.iData)

        while (hashArray[hashVal] != null && hashArray[hashVal]?.iData != -1) {
            hashVal += stepSize
            hashVal %= arraySize
        }
        hashArray[hashVal] = item
    }

    fun delete(key: Int): DataItem? {
        var hashVal = hash1(key)
        val stepSize = hash2(key)

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal]?.iData == key) {
                val temp = hashArray[hashVal]
                hashArray[hashVal] = nonItem
                return temp
            }
            hashVal += stepSize
            hashVal %= arraySize
        }
        return null
    }

    fun find(key: Int): DataItem? {
        var hashVal = hash1(key)
        val stepSize = hash2(key)

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal]?.iData == key) {
                return hashArray[hashVal]
            }
            hashVal += stepSize
            hashVal %= arraySize
        }
        return null
    }
}