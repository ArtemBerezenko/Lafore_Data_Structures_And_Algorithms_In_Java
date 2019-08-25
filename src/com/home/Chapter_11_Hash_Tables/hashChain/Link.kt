package com.home.Chapter_11_Hash_Tables.hashChain

data class Link(val iData: Int) {
    var next: Link? = null

    fun display() {
        print("$iData ")
    }
}