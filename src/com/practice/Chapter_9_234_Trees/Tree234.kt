package com.practice.Chapter_9_234_Trees.kotlin

class Tree234 {
    private var root = Node234()

    fun find(key: Long): Int {
        var curNode = root
        var childNumber = curNode.findItem(key)
        while (true) {
            if (childNumber != -1)
                return childNumber            //found it
            else if (curNode.isLeaf)
                return -1                    //couldn't find it
            else
                curNode = getNextChild(curNode, key)
            childNumber = curNode.findItem(key)
        } //end while
    }

    fun findMinimum(): Long? {
        var currentNode: Node234? = root
        var child = Node234()
        while (currentNode != null) {
            child = currentNode
            currentNode = currentNode.getChild(0)
        }
        return child.getItem(0)?.dData
    }

    fun traverseInOrder() {
        recTraverse(root)
    }

    private fun recTraverse(node: Node234?) {
        if (node != null) {
            recTraverse(node.getChild(0))
            for (i in 0 until node.numItems) {
                print("${node.getItem(i)?.dData} / ")
            }
            recTraverse(node.getChild(1))
        }
    }

    fun insert(dValue: Long) {
        var curNode: Node234? = root
        val tempItem = DataItem(dValue)

        while (true) {
            if (curNode!!.isFull)
            //if node full,
            {
                split(curNode)            //split it
                curNode = curNode.parent //back up
                //search once
                curNode = getNextChild(curNode!!, dValue)
            }//end if(node is full)
            else if (curNode.isLeaf)
            //if node is leaf,
                break                    //go insert
            else
                curNode = getNextChild(curNode, dValue)
        }//end while

        curNode!!.insertItem(tempItem)    //insert new DataItem
    }

    fun split(thisNode: Node234) {
        //assumes node is full
        val itemB: DataItem?
        val itemC: DataItem?
        val parent: Node234?
        val child2: Node234?
        val child3: Node234?
        val itemIndex: Int

        itemC = thisNode.removeItem() //remove rightmost item
        itemB = thisNode.removeItem() //remove next item
        child2 = thisNode.disconnectChild(2) //remove children
        child3 = thisNode.disconnectChild(3)

        val newRight = Node234()

        if (thisNode == root)
        //if this is the root
        {
            root = Node234()            //make a new root
            parent = root                    //and connect thisNode to it
            root.connectChild(0, thisNode)
        } else
            parent = thisNode.parent

        //deal with parent
        itemIndex = parent!!.insertItem(itemB!!) //insert old middle item to parent
        val n = parent.numItems            //total items?

        for (j in n - 1 downTo itemIndex + 1)
        //move parent's connections
        {
            val temp = parent.disconnectChild(j)
            parent.connectChild(j + 1, temp)    //one child to the right
        }

        //connect newRight to parent
        parent.connectChild(itemIndex + 1, newRight)

        //deal with newRight
        newRight.insertItem(itemC!!)            //item C to newRight
        newRight.connectChild(0, child2)    //connect to 0 and 1
        newRight.connectChild(1, child3)    //on newRight
    }//end split()

    fun getNextChild(theNode: Node234, theValue: Long): Node234 {
        var j: Int
        //assumes node is not empty, not full, not a leaf
        val numItems = theNode.numItems
        j = 0
        while (j < numItems)
        //for each item in node
        {                                //are we less?
            if (theValue < theNode.getItem(j)?.dData!!)
                return theNode.getChild(j)!! //return left child
            j++
        } //end for						//we're greater, so
        return theNode.getChild(j)!!       //return right child
    }

    fun displayTree() {
        recDisplayTree(root, 0, 0)
    }

    private fun recDisplayTree(thisNode: Node234, level: Int, childNumber: Int) {
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
