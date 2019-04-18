package SearchBinaryTree;

import BinaryTree.Node;

public class LinkedList<T> {
    Node head;

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
    }

    public void deleteByKey(T key){
        Node currentNode = this.head;
        Node previous = null;

        if(currentNode != null && currentNode.getData() == key){
            this.head = currentNode.getNext();
        }

        while(currentNode != null && currentNode.getData() != key){
            previous = currentNode;
            currentNode = currentNode.getNext();
        }

        if(currentNode != null){
            previous.setNext(currentNode.getNext());
        } else {
            throw new RuntimeException("Not found");
        }
    }
}
