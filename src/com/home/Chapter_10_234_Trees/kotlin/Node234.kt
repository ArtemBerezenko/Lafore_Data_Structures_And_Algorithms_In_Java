package com.home.Chapter_10_234_Trees.kotlin

class Node234 {
    var numItems: Int = 0
        private set
    var parent: Node234? = null
        private set
    private val childArray = arrayOfNulls<Node234>(ORDER)
    private val itemArray = arrayOfNulls<DataItem>(ORDER - 1)

    val isLeaf: Boolean
        get() = if (childArray[0] == null) true else false

    val isFull: Boolean
        get() = if (numItems == ORDER - 1) true else false

    fun connectChild(childNum: Int, child: Node234?) {
        childArray[childNum] = child
        if (child != null)
            child.parent = this
    }

    fun disconnectChild(childNum: Int): Node234? {
        val tempNode = childArray[childNum]
        childArray[childNum] = null
        return tempNode
    }

    fun getChild(childNum: Int): Node234? {
        return childArray[childNum]
    }

    fun getItem(index: Int): DataItem? {
        return itemArray[index]
    }

    fun findItem(key: Long): Int {
        for (j in 0 until ORDER - 1) {
            if (itemArray[j] == null)
                break
            else if (itemArray[j]?.dData == key)
                return j
        }
        return -1
    }

    fun insertItem(newItem: DataItem): Int {
        //assumes node is not full
        numItems++
        val newKey = newItem.dData

        for (j in ORDER - 2 downTo 0) {
            if (itemArray[j] == null)
                continue
            else {
                val itsKey = itemArray[j]?.dData
                itsKey?.let {
                    if (newKey < it)
                        itemArray[j + 1] = itemArray[j]
                    else {
                        itemArray[j + 1] = newItem
                        return j + 1
                    }
                }

            }//end else (not null)
        }//end for
        itemArray[0] = newItem
        return 0
    }

    fun removeItem(): DataItem? {
        //assumes node not empty
        val temp = itemArray[numItems - 1]
        itemArray[numItems - 1] = null
        numItems--
        return temp
    }

    fun displayNode()    //format "/24/56/74/"
    {
        for (j in 0 until numItems)
            itemArray[j]?.displayItem()
        println("/")
    }

    companion object {
        private val ORDER = 4
    }
}
