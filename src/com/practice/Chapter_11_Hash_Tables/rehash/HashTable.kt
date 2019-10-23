package com.home.Chapter_11_Hash_Tables.rehash

class HashTable(private val arraySize: Int) {
    private var hashArray = arrayOfNulls<DataItem>(getPrime(arraySize))
    private val nonItem = DataItem(-1)


    private fun getPrime(min: Int): Int {
        var i = min + 1
        while (true) {
            if (isPrime(i)) {
                return i
            }
            i++
        }
    }

    private fun isPrime(n: Int): Boolean {
        var i = 2
        while (i * i <= n) {
            if (n % i == 0) {
                return false
            }
            i++
        }
        return true
    }


    fun displayTable() {
        hashArray.forEach {
            if (it != null) print("${it.iData} ") else print("** ")
        }
        print("")
    }

    private fun hash(key: Int) = key % arraySize

    private fun rehash() {
        val size = getPrime(hashArray.size * 2)
        val bigArray = arrayOfNulls<DataItem>(size)
        hashArray.forEach { item ->
            if (item != null && item.iData != -1) {
                insert(item, bigArray)
            }
        }
        hashArray = bigArray
    }


    fun insert(item: DataItem, hashArray: Array<DataItem?>? = null) {
        val hashArray = hashArray ?: this.hashArray
        val loadFactor = hashArray.count { it != null } / hashArray.size
        if (loadFactor >= 0.5) {
            rehash()
        }
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