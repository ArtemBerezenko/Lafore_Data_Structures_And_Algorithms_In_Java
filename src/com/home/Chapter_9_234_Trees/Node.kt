package com.home.Chapter_9_234_Trees

class Node {
    var numItems: Int = 0
        private set
    lateinit var parent: Node
        private set
    private val childArray: Array<Node?> = arrayOfNulls<Node?>(ORDER)
    private val itemArray: Array<DataItem?> = arrayOfNulls<DataItem?>(ORDER - 1)

    fun connectChild(childNum: Int, child: Node?) =
            child?.let {
                childArray[childNum] = child
                child.parent = this
            }

    fun disconnectChild(childNum: Int): Node? {
        val tempNode = childArray[childNum]
        childArray[childNum] = null
        return tempNode
    }

    fun isLeaf() = childArray[0] == null

    fun isFull() = numItems == ORDER - 1

    fun findItem(key: Int): Int {
        for (i in 0 until ORDER - 1) {
            if (itemArray[i] == null) {
                break
            } else if (itemArray[i]?.dData == key) return i
        }
        return -1
    }

    fun insertItem(newItem: DataItem): Int {
        numItems++
        val newKey = newItem.dData
        for (i in ORDER - 2 downTo 0) {
            if (itemArray[i] == null) {
                continue
            } else {
                val itsKey = itemArray[i]?.dData
                if (itsKey != null && newKey < itsKey) {
                    itemArray[i + 1] = itemArray[i]
                } else {
                    itemArray[i + 1] = newItem
                    return i + 1
                }
            }
        }
        itemArray[0] = newItem
        return 0
    }

    fun removeItem(): DataItem? {
        val temp = itemArray[numItems - 1]
        itemArray[numItems - 1] = null
        numItems--
        return temp
    }

    fun getItem(index: Int): DataItem? = itemArray[index]

    fun getChild(index: Int): Node? = childArray[index]

    fun displayNode() {
        for (i in 0 until numItems) {
            itemArray[i]?.displayItem()
        }
        println("/")
    }

    companion object {
        private const val ORDER = 4
    }
}
