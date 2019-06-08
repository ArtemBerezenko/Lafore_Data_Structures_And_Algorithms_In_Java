package com.practice.Chapter_8_Trees

import java.util.*

class Tree {
    var root: Node? = null

    fun find(key: Int) : Node? {
        var current = root
        while (current?.iData != key) {
            if (key < current?.iData!!) {
                current = current.leftChild
            } else {
                current = current.rightChild
            }
            current ?: return null
        }
        return current
    }

    fun insert(id: Int, dd: Double) {
        val node = Node()
        node.iData = id
        node.dData = dd
        if (root == null) {
            root = node
        } else {
            var current = root
            var parent: Node? = null
            while (true) {
                parent = current
                if (id < current?.iData!!) {
                    current = current.leftChild
                    if (current == null) {
                        parent?.leftChild = node
                        return
                    }
                } else {
                    current = current.rightChild
                    if (current == null) {
                        parent?.rightChild = node
                        return
                    }
                }
            }
        }
    }

    fun minimum(): Node {
        var current: Node
        var last: Node? = null

        current = this.root!!

        while (current != null) {
            last = current
            current = current.leftChild!!
        }
        return last!!
    }

    fun maximum(): Node {
        var current: Node
        var last: Node? = null

        current = this.root!!

        while (current != null) {
            last = current
            current = current.rightChild!!
        }
        return last!!
    }


    fun delete(key: Int): Boolean {
        var current = root
        var parent = root
        var isLeftChild = true

        while (current?.iData != key) {
            parent = current
            if (key < current?.iData!!) {
                isLeftChild = true
                current = current.leftChild
            } else {
                isLeftChild = false
                current = current.rightChild
            }
            if (current == null) {
                return false
            }
            if (current.leftChild == null && current.rightChild == null) {
                if (current == root) {
                    root = null
                } else if (isLeftChild) {
                    parent?.leftChild = null
                } else {
                    parent?.rightChild = null
                }

            } else if (current.rightChild == null) {
                if (current == root) {
                    root = current.leftChild
                } else if (isLeftChild) {
                    parent?.leftChild = current.leftChild
                } else {
                    parent?.rightChild = current.leftChild
                }
            } else if (current.leftChild == null) {
                if (current == root) {
                    root = current.rightChild
                } else if (isLeftChild) {
                    parent?.leftChild = current.rightChild
                } else {
                    parent?.rightChild = current.rightChild
                }
            } else {
                val successor = getSuccessor(current)
                if (current == root) {
                    root = successor
                } else if (isLeftChild) {
                    parent?.leftChild = successor
                } else {
                    parent?.rightChild = successor
                }
            }
        }
        return true
    }

    private fun getSuccessor(delNode: Node): Node {
        var successorParent = delNode
        var successor = delNode
        var current = delNode.rightChild
        while (current != null) {
            successorParent = successor
            successor = current
            current = current.leftChild
        }
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild
            successor.rightChild = delNode.rightChild
        }
        return successor
    }

    fun traverse(traverseType: Int) {
        when(traverseType) {
            1 -> {
                print("\nPreorder traversal: ")
                preOrder(root)
            }
            2 -> {
                print("\nInorder traversal: ")
                inOrder(root)
            }
            3 -> {
                print("\nPostorder traversal: ")
                postOrder(root)
            }


        }
    }

    private fun postOrder(localRoot: Node?) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild)
            postOrder(localRoot.rightChild)
            print("${localRoot.iData} ")
        }
    }

    private fun inOrder(localRoot: Node?) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild)
            print("${localRoot.iData} ")
            inOrder(localRoot.rightChild)
        }
    }

    private fun preOrder(localRoot: Node?) {
        if (localRoot != null) {
            print("${localRoot.iData} ")
            preOrder(localRoot.leftChild)
            preOrder(localRoot.rightChild)
        }
    }

    fun displayTree() {
        val globalStack = Stack<Node>()
        globalStack.push(root)
        var nBlanks = 32
        var isRowEmpty = false
        println("..............................................................")
        while (!isRowEmpty) {
            val localStack = Stack<Node>()
            isRowEmpty = true
            for (j in 0 until nBlanks) {
                print(" ")
            }
            while (!globalStack.isEmpty()) {
                val temp = globalStack.pop()
                if (temp != null) {
                    print(temp.iData)
                    localStack.push(temp.leftChild)
                    localStack.push(temp.rightChild)

                    if (temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false
                    }
                } else {
                    print("--")
                    localStack.push(null)
                    localStack.push(null)
                }
                for (i in 0 .. nBlanks * 2 - 2) {
                    print(" ")
                }
            }
            println()
            nBlanks /= 2
            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop())
            }
        }
        println("................................................................")
    }
}




















