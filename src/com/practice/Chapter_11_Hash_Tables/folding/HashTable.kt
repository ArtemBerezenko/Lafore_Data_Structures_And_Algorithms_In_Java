package com.home.Chapter_11_Hash_Tables.folding

class HashTable(private val arraySize: Int) {
    private val hashArray = arrayOfNulls<DataItem>(arraySize)
    val nonItem = DataItem(-1)

    fun displayTable() {
        hashArray.forEach {
            if (it != null) print("${it.iData} ") else print("** ")
        }
        print("")
    }

    private fun hash(key: Int): Int {
        val arrayDigitNumber = hashArray.size.toString().length
        val keyGroup = mutableListOf<Int>()
        var i = 0
        var intStr = StringBuilder()
        key.toString().forEach { char ->
            if (i >= arrayDigitNumber) {
                keyGroup.add(intStr.toString().toInt())
                intStr = StringBuilder()
                i = 0
            }
            if (i < arrayDigitNumber) {
                intStr.append(char)
                i++
            }
        }
        if (intStr.isNotEmpty()) {
            keyGroup.add(intStr.toString().toInt())
        }
        val sum = keyGroup.sum()
        return keyGroup.sum()
    }

    fun hashFunc(key: Int): Int {
        var key = key
        var groupSize = 1
        var temp = arraySize
        var hashVal = 0

        while (temp > 0) {
            temp /= 10
            groupSize *= 10
        }

        while (key > 0) {
            hashVal += key % groupSize
            key /= groupSize
        }

        return hashVal
    }

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