package com.home.Chapter_11_Hash_Tables.hash

class HashTable(private val arraySize: Int) {
    private val hashArray = arrayOfNulls<DataItem>(arraySize)
    val nonItem = DataItem(-1)

    fun displayTable() {
        hashArray.forEach {
            if (it != null) print("${it.iData} ") else print("** ")
        }
        print("")
    }

    private fun hash(key: Int) = key % arraySize

    fun insert(item: DataItem) {
        var hashVal = hash(item.iData)

        while (hashArray[hashVal] != null && hashArray[hashVal]?.iData != -1) {
            ++hashVal
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