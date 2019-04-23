package SearchBinaryTree;

import SearchBinaryTreeApi.Node;

public class StockList extends LinkedList<Lamp> {

    public void printList(){
        Node<Lamp> currentNode = this.head;

        System.out.println("StockList: ");

        while(currentNode != null){
            currentNode.getData().printData();

            currentNode = currentNode.getNext();
        }
    }
}
