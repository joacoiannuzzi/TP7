package SearchBinaryTreeApi;

import BinaryTree.DynamicQueue;
import SearchBinaryTree.Lamp;
import SearchBinaryTree.SearchBinaryTree;

import java.util.ArrayList;
import java.util.Scanner;

public class ApiLamp extends SearchBinaryTreeApi<Lamp> {

    @Override
    public void perlevel(SearchBinaryTree<Lamp> a) {
        if (a.isEmpty())
            return;
        ArrayList<Lamp> listRoot = new ArrayList<Lamp>();
        DynamicQueue<SearchBinaryTree<Lamp>> queueTree = new DynamicQueue();
        queueTree.enqueue(a);

        while(!queueTree.isEmpty()){
            listRoot.add(makeQueue(queueTree));
        }

        for (Lamp o : listRoot) {
            o.printData();
        }
    }

    @Override
    public void inorder(SearchBinaryTree<Lamp> a) {
            if (!a.isEmpty()) {
                inorder(a.getLeft());
                a.getRoot().printData();
                inorder(a.getRight());
            }
    }

    public void options(SearchBinaryTree<Lamp> a){

        System.out.println("Options: ");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch (option){
            case 0:
                Lamp lamp = new Lamp(scanner.next(), scanner.next(), scanner.nextInt(), scanner.nextInt());
                a.insert(lamp);
        }
    }
}
