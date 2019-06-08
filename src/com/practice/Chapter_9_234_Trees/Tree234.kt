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

    //Exercise 1
    fun findMinimum() {
        var curNode: Node234? = root
        var answer = Node234()
        while (curNode != null) {
            answer = curNode
            curNode = curNode.getChild(0)
        }
        println("Minimum value is " + answer.getItem(0)?.dData)
    }

    //Exercise 2
    fun traverseInOrder() {
        recTraverse(root)
    }

    private fun recTraverse(curNode: Node234?) {
        //if it's a leaf, spew it all out
        curNode?.let {
            if (curNode.isLeaf) {
                for (j in 0 until curNode.numItems)
                    curNode.getItem(j)?.displayItem()
                return
            } else {
                for (j in 0 until curNode.numItems + 1) {
                    recTraverse(curNode.getChild(j))
                    if (j < curNode.numItems)
                        curNode.getItem(j)?.displayItem()
                }
            }//otherwise get child 0, print item 0, get child 1, print item 1...
        }
    }

    //Exercise 3b
    //write over the original array (passed by reference)
    //by iterating through the tree and increasing index of array (i)
    //after each insertion
    fun sortTraverse(theArray: LongArray) {
        val i = 0
        recSortTraverse(root, theArray, i)
    }

    private fun recSortTraverse(curNode: Node234, theArray: LongArray, i: Int): Int {
        var i = i
        //if it's a leaf, spew it all out
        if (curNode.isLeaf) {
            for (j in 0 until curNode.numItems) {
                curNode.getItem(j)?.let { theArray[i] = it.dData }
                i++
            }
            return i
        } else {
            for (j in 0 until curNode.numItems + 1) {
                i = recSortTraverse(curNode.getChild(j)!!, theArray, i)
                if (j < curNode.numItems) {
                    theArray[i] = curNode.getItem(j)?.dData!!
                    i++
                }
            }
            return i
        }//otherwise get child 0, print item 0, get child 1, print item 1...
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
