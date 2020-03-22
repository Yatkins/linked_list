package edu.ti.collections.list.linked;

public class LinkedList {
    private static class Node {
        Object payload;
        Node next = null;

        public Node(Object payload) {
            this.payload = payload;
        }

        public Object getPayload() {
            return payload;
        }

        public void setPayload(Object payload) {
            this.payload = payload;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head = null;

    public LinkedList() {
        // nothing
    }

    public LinkedList(Object payload) {
        head = new Node(payload);
    }

    public boolean isEmpty() {
        return (head == null);
    }

    //returns last node
    private Node end() {
        Node endNode = head;
        while (endNode.getNext() != null) {
            endNode = endNode.getNext();
        }
        return endNode;
    }

    //returns node size
    public int size() {
        Node node = head;
        int size = 1;
        while (node.getNext() != null) {
            node = node.getNext();
            size ++;
        }
        return size;
    }

    //inserts new node with object at head of list
    public void insert(Object object) {
        Node newNode = new Node(object);
        newNode.setNext(head); //newNode points to where head was pointing to
        head = newNode; //head points to newNode
    }

    //inserts new node with object at end of list
    public void append(Object object) {
        Node newNode = new Node(object);
        Node endNode = this.end();
        endNode.setNext(newNode);
    }

    public Object get(int n) {
        Node node = head;
        if (n > (this.size() - 1)) {
            return null;
        } else {
            for (int i = 0; i < n; i++) {
                node = node.getNext();
            }
        }return node.getPayload();
    }

    public Object remove(int n) {
        Node node = head;
        Node previousNode = null;
        Object removed = null;
        if (n < this.size() && (head != null)) {
            if (n == 0) {
                head = node.getNext();
                removed = node.getPayload();
            } else {
                for (int i = 0; i < n; i++) {
                    previousNode = node;
                    node = node.getNext();
                }
                previousNode.setNext(node.getNext());
                removed = node.getPayload();
            }
        } return removed;
    }

    public Object remove(Object object) {
        Node node = head;
        Node previousNode = null;
        Object removed = null;
        if (head != null){
         boolean objectExists = false;
                for (int count = 0; count < this.size(); count++)
                { if (node.getPayload().equals(object))
                    { objectExists = true;
                    } else {
                        previousNode = node;
                        node = node.getNext();
                    }
                }if (objectExists)
                { previousNode.setNext(node.getNext());
                    removed = node.getPayload();
                } else {
                    removed = null;
            }
        } return removed;
    }
}