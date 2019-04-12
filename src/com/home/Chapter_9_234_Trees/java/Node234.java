package com.home.Chapter_9_234_Trees.java;

class Node234 {
    private static final int ORDER = 4;
    private int numItems;
    private Node234 parent;
    private Node234 childArray[] = new Node234[ORDER];
    private DataItem itemArray[] = new DataItem[ORDER - 1];

    public void connectChild(int childNum, Node234 child) {
        childArray[childNum] = child;
        if (child != null)
            child.parent = this;
    }

    public Node234 disconnectChild(int childNum) {
        Node234 tempNode = childArray[childNum];
        childArray[childNum] = null;
        return tempNode;
    }

    public Node234 getChild(int childNum) {
        return childArray[childNum];
    }

    public Node234 getParent() {
        return parent;
    }

    public boolean isLeaf() {
        return (childArray[0] == null) ? true : false;
    }

    public int getNumItems() {
        return numItems;
    }

    public DataItem getItem(int index) {
        return itemArray[index];
    }

    public boolean isFull() {
        return (numItems == ORDER - 1) ? true : false;
    }

    public int findItem(long key) {
        for (int j = 0; j < ORDER - 1; j++) {
            if (itemArray[j] == null)
                break;
            else if (itemArray[j].dData == key)
                return j;
        }
        return -1;
    }

    public int insertItem(DataItem newItem) {
        //assumes node is not full
        numItems++;
        long newKey = newItem.dData;

        for (int j = ORDER - 2; j >= 0; j--) {
            if (itemArray[j] == null)
                continue;
            else {
                long itsKey = itemArray[j].dData;
                if (newKey < itsKey)
                    itemArray[j + 1] = itemArray[j];
                else {
                    itemArray[j + 1] = newItem;
                    return j + 1;
                }
            }//end else (not null)
        }//end for
        itemArray[0] = newItem;
        return 0;
    }

    public DataItem removeItem() {
        //assumes node not empty
        DataItem temp = itemArray[numItems - 1];
        itemArray[numItems - 1] = null;
        numItems--;
        return temp;
    }

    public void displayNode()    //format "/24/56/74/"
    {
        for (int j = 0; j < numItems; j++)
            itemArray[j].displayItem();
        System.out.println("/");
    }
}
