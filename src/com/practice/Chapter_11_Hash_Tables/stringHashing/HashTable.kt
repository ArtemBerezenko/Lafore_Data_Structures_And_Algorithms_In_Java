package com.practice.Chapter_11_Hash_Tables.stringHashing


class HashTable(private val arraySize: Int) {
    private val hashArray = arrayOfNulls<DataItem>(arraySize)
    private val nonItem = DataItem("")

    fun displayTable() {
        hashArray.forEach {
            if (it != null) print("${it.sData} ") else print("** ")
        }
        print("")
    }

    private fun hash(key: String): Int {
        var hashVal = 0
        for (i in 0 until key.length) {
            val letter = key[i].toInt()
            hashVal = (hashVal * 27 + letter) % arraySize
        }
        return hashVal
    }

    fun insert(item: DataItem) {
        var hashVal = hash(item.sData)

        while (hashArray[hashVal] != null && hashArray[hashVal]?.sData != "") {
            ++hashVal
            hashVal %= arraySize
        }
        hashArray[hashVal] = item
    }

    fun delete(key: String): DataItem? {
        var hashVal = hash(key)

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal]?.sData == key) {
                val temp = hashArray[hashVal]
                hashArray[hashVal] = nonItem
                return temp
            }
            ++hashVal
            hashVal %= arraySize
        }
        return null
    }

    fun find(key: String): DataItem? {
        var hashVal = hash(key)
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal]?.sData == key) {
                return hashArray[hashVal]
            }
            ++hashVal
            hashVal %= arraySize
        }
        return null
    }
}
