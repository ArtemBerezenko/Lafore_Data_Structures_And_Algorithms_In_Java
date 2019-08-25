package com.home.Chapter_11_Hash_Tables.hashChain

class SortedList(var first: Link? = null) {

    fun insert(link: Link) {
        val key = link.iData
        var previous: Link? = null;
        var current: Link? = first

        while (current != null && key > current.iData) {
            previous = current
            current = current.next
        }
        if (previous == null) {
            first = link
        } else {
            previous.next = link
        }
        link.next = current
    }

    fun delete(key: Int) {
        var previous: Link? = null;
        var current: Link? = first

        while (current != null && key != current.iData) {
            previous = current
            current = current.next
        }

        if (previous == null) {
            first = first?.next
        } else {
            previous.next = current?.next
        }
    }

    fun find(key: Int): Link? {
        var current: Link? = first
        while (current != null && current.iData <= key) {
            if (current.iData == key) return current
            current = current.next
        }
        return null
    }

    fun displayList() {
        print("List (first --> last): ")
        var current: Link? = first
        while (current != null) {
            current.display()
            current = current.next
        }
        println("")
    }

}