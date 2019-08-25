package com.home.Chapter_11_Hash_Tables.hashChain

class HashTable(private val arraySize: Int) {
    private val hashArray = arrayOfNulls<SortedList>(arraySize)

    init {
        for (i in 0 until arraySize) {
            hashArray[i] = SortedList()
        }
    }

    fun displayTable() {
        hashArray.forEachIndexed { i, list ->
            print("$i. ")
            print("${list?.displayList()} ")
        }
    }

    private fun hashFunc(key: Int) = key % arraySize

    fun insert(link: Link) {
        val hashVal = hashFunc(link.iData)
        hashArray[hashVal]?.insert(link)
    }

    fun delete(key: Int) {
        val hashVal = hashFunc(key)
        hashArray[hashVal]?.delete(key)
    }

    fun find(key: Int): Link? {
        val hashVal = hashFunc(key)
        return hashArray[hashVal]?.find(key)
    }
}