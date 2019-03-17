package com.home.Chapter_9_234_Trees

class Tree234 {
    private var root = Node()

    fun find(key: Int): Any {
        var curNode = root
        var childNumber: Int
        while (true) {
            childNumber = curNode.findItem(key)
            if (childNumber != -1) return childNumber
            else if (curNode.isLeaf()) return -1
            else curNode = getNextChild(curNode, key)
        }
    }

    fun insert(dValue: Int) {
        var curNode = root
        val tempItem = DataItem(dValue)
        while (true) {
            if (curNode.isFull()) {
                split(curNode)
                curNode = curNode.parent
                curNode = getNextChild(curNode, dValue)
            } else if (curNode.isLeaf()) break
            else curNode = getNextChild(curNode, dValue)
        }
        curNode.insertItem(tempItem)
    }

    private fun split(thisNode: Node) {
        val itemC: DataItem? = thisNode.removeItem()
        val itemB: DataItem? = thisNode.removeItem()
        val parent: Node
        val child2: Node? = thisNode.disconnectChild(2)
        val child3: Node? = thisNode.disconnectChild(3)
        val itemIndex: Int
        val newRight = Node()

        if (thisNode == root) {
            root = Node()
            parent = root
            root.connectChild(0, thisNode)
        } else parent = thisNode.parent

        itemIndex = parent.insertItem(itemB!!)

        for (i in parent.numItems - 1 downTo itemIndex + 1) {
            val temp = parent.disconnectChild(i)
            parent.connectChild(i + 1, temp)
        }
        parent.connectChild(itemIndex + 1, newRight)
        newRight.insertItem(itemC!!)
        newRight.connectChild(0, child2)
        newRight.connectChild(1, child3)
    }

    private fun getNextChild(theNode: Node, theValue: Int): Node {
        for (i in 0 until theNode.numItems) {
            if (theValue < theNode.getItem(i)?.dData!!) return theNode.getChild(i)!!
        }
        return theNode.getChild(0)!!
    }

    fun displayTree() {
        recDisplayTree(root, 0, 0)
    }

    private fun recDisplayTree(thisNode: Node, level: Int, childNumber: Int) {
        print("level=$level child=$childNumber ")
        thisNode.displayNode()

        for (i in 0 until thisNode.numItems + 1) {
            val nextNode = thisNode.getChild(i)
            nextNode?.let { recDisplayTree(nextNode, level + 1, i) }
            return
        }
    }

}
