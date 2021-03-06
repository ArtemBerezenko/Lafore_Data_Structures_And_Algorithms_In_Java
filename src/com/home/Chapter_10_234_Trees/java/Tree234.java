package com.home.Chapter_10_234_Trees.java;

class Tree234 {
    private Node234 root = new Node234();

    public int find(long key) {
        Node234 curNode = root;
        int childNumber;
        while (true) {
            if ((childNumber = curNode.findItem(key)) != -1)
                return childNumber;            //found it
            else if (curNode.isLeaf())
                return -1;                    //couldn't find it
            else
                curNode = getNextChild(curNode, key);
        } //end while
    }

    //Exercise 1
    public void findMinimum() {
        Node234 curNode = root;
        Node234 answer = new Node234();
        while ((curNode = curNode.getChild(0)) != null)
            answer = curNode;
        System.out.println("Minimum value is " + answer.getItem(0).dData);
    }

    //Exercise 2
    public void traverseInOrder() {
        recTraverse(root);
    }

    private void recTraverse(Node234 curNode) {
        //if it's a leaf, spew it all out
        if (curNode.isLeaf()) {
            for (int j = 0; j < curNode.getNumItems(); j++)
                curNode.getItem(j).displayItem();
            return;
        }
        //otherwise get child 0, print item 0, get child 1, print item 1...
        else {
            for (int j = 0; j < curNode.getNumItems() + 1; j++) {
                recTraverse(curNode.getChild(j));
                if (j < curNode.getNumItems())
                    curNode.getItem(j).displayItem();
            }
        }
    }

    //Exercise 3b
    //write over the original array (passed by reference)
    //by iterating through the tree and increasing index of array (i)
    //after each insertion
    public void sortTraverse(long[] theArray) {
        int i = 0;
        recSortTraverse(root, theArray, i);
    }

    private int recSortTraverse(Node234 curNode, long[] theArray, int i) {
        //if it's a leaf, spew it all out
        if (curNode.isLeaf()) {
            for (int j = 0; j < curNode.getNumItems(); j++) {
                theArray[i] = curNode.getItem(j).dData;
                i++;
            }
            return i;
        }
        //otherwise get child 0, print item 0, get child 1, print item 1...
        else {
            for (int j = 0; j < curNode.getNumItems() + 1; j++) {
                i = recSortTraverse(curNode.getChild(j), theArray, i);
                if (j < curNode.getNumItems()) {
                    theArray[i] = curNode.getItem(j).dData;
                    i++;
                }
            }
            return i;
        }
    }

    public void insert(long dValue) {
        Node234 curNode = root;
        DataItem tempItem = new DataItem(dValue);

        while (true) {
            if (curNode.isFull())        //if node full,
            {
                split(curNode);            //split it
                curNode = curNode.getParent(); //back up
                //search once
                curNode = getNextChild(curNode, dValue);
            }//end if(node is full)

            else if (curNode.isLeaf())    //if node is leaf,
                break;                    //go insert

            else
                curNode = getNextChild(curNode, dValue);
        }//end while

        curNode.insertItem(tempItem);    //insert new DataItem
    }

    public void split(Node234 thisNode) {
        //assumes node is full
        DataItem itemB, itemC;
        Node234 parent, child2, child3;
        int itemIndex;

        itemC = thisNode.removeItem(); //remove rightmost item
        itemB = thisNode.removeItem(); //remove next item
        child2 = thisNode.disconnectChild(2); //remove children
        child3 = thisNode.disconnectChild(3);

        Node234 newRight = new Node234();

        if (thisNode == root)                    //if this is the root
        {
            root = new Node234();            //make a new root
            parent = root;                    //and connect thisNode to it
            root.connectChild(0, thisNode);
        } else
            parent = thisNode.getParent();

        //deal with parent
        itemIndex = parent.insertItem(itemB); //insert old middle item to parent
        int n = parent.getNumItems();            //total items?

        for (int j = n - 1; j > itemIndex; j--)    //move parent's connections
        {
            Node234 temp = parent.disconnectChild(j);
            parent.connectChild(j + 1, temp);    //one child to the right
        }

        //connect newRight to parent
        parent.connectChild(itemIndex + 1, newRight);

        //deal with newRight
        newRight.insertItem(itemC);            //item C to newRight
        newRight.connectChild(0, child2);    //connect to 0 and 1
        newRight.connectChild(1, child3);    //on newRight
    }//end split()

    public Node234 getNextChild(Node234 theNode, long theValue) {
        int j;
        //assumes node is not empty, not full, not a leaf
        int numItems = theNode.getNumItems();
        for (j = 0; j < numItems; j++)        //for each item in node
        {                                //are we less?
            if (theValue < theNode.getItem(j).dData)
                return theNode.getChild(j); //return left child
        } //end for						//we're greater, so
        return theNode.getChild(j);        //return right child
    }

    public void displayTree() {
        recDisplayTree(root, 0, 0);
    }

    private void recDisplayTree(Node234 thisNode, int level, int childNumber) {
        System.out.print("level=" + level + " child=" + childNumber + " ");
        thisNode.displayNode();

        //call ourselves for each child of this node
        int numItems = thisNode.getNumItems();
        for (int j = 0; j < numItems + 1; j++) {
            Node234 nextNode = thisNode.getChild(j);
            if (nextNode != null)
                recDisplayTree(nextNode, level + 1, j);
            else
                return;
        }
    }
} //end class tree234
