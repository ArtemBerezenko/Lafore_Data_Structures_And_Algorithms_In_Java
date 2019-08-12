package com.practice.Chapter_10_23_Trees

class Tree23 {
    private var root = Node23()

    fun find(key: Long): Int {
        var curNode = root
        var childNumber = curNode.findItem(key)
        while (true) {
            when {
                childNumber != -1 -> return childNumber
                curNode.isLeaf -> return -1
                else -> curNode = getNextChild(curNode, key)
            }
            childNumber = curNode.findItem(key)
        }
    }

    fun insert(dValue: Long) {
        var curNode: Node23? = root
        val tempItem = DataItem(dValue)
        while(!curNode!!.isLeaf) {
            curNode = getNextChild(curNode, dValue);
        }
        if(curNode.isFull) {
            split(curNode, tempItem)
        } else {
            curNode.insertItem(tempItem)
        }
    }

    //split a full node, insert the middle value into the parent
    fun split(thisNode: Node23, newItem: DataItem): Node23 {
        val parent = thisNode.parent

        //sort the two values from the node as well as the new item
        val sortedItems = arrayOf(newItem, thisNode.getItem(0), thisNode.getItem(1)).sortedBy { it?.dData }

        //empty out the current node and put the lowest value as only data item
        with(thisNode) {
            removeItem()
            removeItem()
            insertItem(sortedItems[0]!!)
        }

        //make a new right node for the largest value
        val newRightNode = Node23().apply {
            insertItem(sortedItems[2]!!)
        }

        //if this node is the root, make a new root
        if (thisNode == this.root) {
            this.root = Node23().apply {
                insertItem(sortedItems[1]!!)
                connectChild(0, thisNode)
                connectChild(1, newRightNode)
            }
            return newRightNode
        } else if (parent!!.isFull) {
            val sibling = split(parent, sortedItems[1]!!)

            //case 1: split node is leftmost child of parent
            if (thisNode == parent.getChild(0)) {
                val childB = parent.disconnectChild(1)
                val childC = parent.disconnectChild(2)
                parent.connectChild(1, newRightNode)
                sibling.connectChild(0, childB)
                sibling.connectChild(1, childC)
            } else if (thisNode == parent.getChild(1)) {
                val childC = parent.disconnectChild(2)
                sibling.connectChild(0, newRightNode)
                sibling.connectChild(1, childC)
            } else {
                parent.disconnectChild(2)
                sibling.connectChild(0, thisNode)
                sibling.connectChild(1, newRightNode)
            }

            return newRightNode
        } else {
            parent.insertItem(sortedItems[1]!!)

            //--then connect the newRightNode to parent--//

            //if the new Right node is made from the leftmost child of parent...
            if (thisNode == parent.getChild(0)) {
                //shift current middle child to the right
                parent.connectChild(2, parent.disconnectChild(1))
                //and put the newRightNode as middle child
                parent.connectChild(1, newRightNode)
            } else
                parent.connectChild(2, newRightNode)//otherwise just attach new Right node as rightmost child of parent
        }//otherwise, add the middle value to the parent
        //if the parent is full, call split again
        //then readjust child relationships

        return newRightNode
    }//end split()

//    private fun split(thisNode: Node23, value: DataItem) {
//        val itemB: DataItem? = thisNode.removeItem()
//        val itemA: DataItem? = thisNode.removeItem()
//        val parent: Node23?
//        val child2: Node23? = thisNode.disconnectChild(2)
//        val itemIndex: Int
//        val newRight = Node23()
//
//        if (thisNode == root) {
//            root = Node23()
//            parent = root
//            root.connectChild(0, thisNode)
//        } else
//            parent = thisNode.parent
//
//        //deal with parent
//        itemIndex = parent!!.insertItem(itemA!!)
//        for (i in parent.numItems - 1 downTo itemIndex + 1) {
//            val temp = parent.disconnectChild(i)
//            parent.connectChild(i + 1, temp)
//        }
//        parent.connectChild(itemIndex + 1, newRight)
//        newRight.insertItem(value)
//        newRight.connectChild(0, child2)
//    }

    private fun getNextChild(theNode: Node23, theValue: Long): Node23 {
        var j = 0
        //assumes node is not empty, not full, not a leaf
        val numItems = theNode.numItems
        while (j < numItems) {
            //are we less?
            if (theValue < theNode.getItem(j)?.dData!!)
                return theNode.getChild(j)!!
            j++
        } 					                //we're greater, so
        return theNode.getChild(j)!!       //return right child
    }

    fun findMinimum(): Long? {
        var currentNode: Node23? = root
        var child = Node23()
        while (currentNode != null) {
            child = currentNode
            currentNode = currentNode.getChild(0)
        }
        return child.getItem(0)?.dData
    }

    fun traverseInOrder() {
        recTraverse(root)
    }

    private fun recTraverse(node: Node23?) {
        if (node != null) {
            recTraverse(node.getChild(0))
            for (i in 0 until node.numItems) {
                print("${node.getItem(i)?.dData} / ")
            }
            recTraverse(node.getChild(1))
        }
    }

    fun sortTraverse(array: LongArray) {
        recSortTraverse(array, root)
    }

    private fun recSortTraverse(array: LongArray, node: Node23, index: Int = 0): Int {
        var i = index
        if (node.isLeaf) {
            for (j in 0 until node.numItems) {
                array[i++] = node.getItem(j)?.dData!!
            }
        } else {
            for (j in 0 .. node.numItems) {
                i = recSortTraverse(array, node.getChild(j)!!, i)
                if (j < node.numItems) array[i++] = node.getItem(j)?.dData!!
            }
        }
        return i
    }

    fun displayTree() {
        recDisplayTree(root, 0, 0)
    }

    private fun recDisplayTree(thisNode: Node23, level: Int, childNumber: Int) {
        print("level=$level child=$childNumber ")
        thisNode.displayNode()

        //call ourselves for each child of this node
        val numItems = thisNode.numItems
        for (j in 0 until numItems + 1) {
            val nextNode = thisNode.getChild(j)
            if (nextNode != null)
                recDisplayTree(nextNode, level + 1, j)
            else
                return
        }
    }
} //end class tree234
