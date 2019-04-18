package SearchBinaryTree;

import BinaryTree.Node;

public class LinkedList<T> {
    Node head;
    int size;

    public LinkedList() {
        this.size = 0;
    }

    public void insert(T data){
        Node newNode = new Node(data);
        newNode.setNext(null);

        if(this.head == null){
            this.head = newNode;
        } else {
            Node last = this.head;
            while(last.getNext() != null){
                last = last.getNext();
            }

            last.setNext(newNode);
        }

        size++;
    }

    public void deleteByKey(T key){
        Node currentNode = this.head;
        Node previous = null;

        if(currentNode != null && currentNode.getData() == key){
            this.head = currentNode.getNext();
            size--;
            return;
        }

        while(currentNode != null && currentNode.getData() != key){
            previous = currentNode;
            currentNode = currentNode.getNext();
        }

        if(currentNode != null){
            previous.setNext(currentNode.getNext());
            size--;
        } else {
            throw new RuntimeException("Not found");
        }
    }

    public int getSize() {
        return size;
    }
}
