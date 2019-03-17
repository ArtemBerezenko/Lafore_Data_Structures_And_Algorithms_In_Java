package com.home.Chapter_8_Trees

class Node {
    var iData: Int? = null
    var dData: Double? = null
    var leftChild: Node? = null
    var rightChild: Node? = null

    fun displayNode() {
        print('{')
        print(iData)
        print(", ")
        print(dData)
        print("} ")
    }

}