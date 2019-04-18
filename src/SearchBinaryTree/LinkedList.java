package SearchBinaryTree;

import BinaryTree.Node;

public class LinkedList<T> {

    Node<T> head;
    private int size;

    public LinkedList() {
        this.size = 0;
    }

    public void insert(T data){
        Node<T> newNode = new Node(data);
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
        Node<T> currentNode = this.head;
        Node<T> previous = null;

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

    public T getAtPosition(int index){
        Node<T> currentNode = this.head;

        if(index == 0 && currentNode != null){
            return currentNode.getData();
        }

        int counter = 0;
        Node<T> element = new Node<T>();

        while (currentNode != null){
            if(counter == index){
                element =  currentNode;
                break;
            } else {
                currentNode = currentNode.getNext();
                counter++;
            }
        }

        return element.getData();
    }

    public int getSize() {
        return size;
    }
}
