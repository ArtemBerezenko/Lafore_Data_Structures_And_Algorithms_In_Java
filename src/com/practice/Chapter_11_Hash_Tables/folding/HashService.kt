package com.practice.Chapter_11_Hash_Tables.folding

import com.home.Chapter_11_Hash_Tables.folding.DataItem

class HashService(private val hashArray: Array<DataItem?>) {

    fun hash(key: Int): Int {
        val arrayDigitNumber = hashArray.size.toString().length
        val keyGroup = mutableListOf<List<Int>>()
        var i = 0
        val list = mutableListOf<Int>()
        key.toString().forEach { char ->
            if (i >= arrayDigitNumber) {
                keyGroup.add(list)
                list.clear()
                i = 0
            }
            if (i < arrayDigitNumber) {
                list.add(char.toString().toInt())
                i++
            }
        }
        return 10
    }
}