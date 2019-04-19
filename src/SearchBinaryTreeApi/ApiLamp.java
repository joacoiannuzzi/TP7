package SearchBinaryTreeApi;

import BinaryTree.DynamicQueue;
import BinaryTreeApi.Tree;
import SearchBinaryTree.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ApiLamp extends SearchBinaryTreeApi<Lamp> {

    @Override
    public void perlevel(SearchBinaryTree<Lamp> a) {
        if (a.isEmpty())
            return;
        ArrayList<Lamp> listRoot = new ArrayList<Lamp>();
        DynamicQueue<Tree<Lamp>> queueTree = new DynamicQueue();
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

    public void insert(SearchBinaryTree<Lamp> a, Lamp lamp) {
        a.insert(lamp);
    }

    public void remove(LampTree a, String code) {
        a.remove(a.search(code));
    }

    public void modifyAmount(LampTree a, String code, int q) {
        a.search(code).setAmount(q);
    }

    public void modifyType(LampTree a, String code, String type) {
        a.search(code).setLampType(type);
    }

    public void modifyWatts(LampTree a, String code, int watts) {
        a.search(code).setLampWatts(watts);
    }

    public void showStock(SearchBinaryTree<Lamp> a) {
        inorder(a);
    }

    public void options(LampTree a){

        System.out.println("Options: ");
        System.out.println("0 -> Add a Lamp");
        System.out.println("1 -> Remove a Lamp");
        System.out.println("2 -> Modify a Lamp");
        System.out.println("3 -> Show stock");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch (option){
            case 0:
                System.out.println("Enter an: lampCode, lampType, lampWatts, lampAmount");
                Lamp lamp = new Lamp(scanner.next().toUpperCase(), scanner.next(), scanner.nextInt(), scanner.nextInt());
                insert(a, lamp);
                break;
            case 1:
                remove(a, scanner.next());
                break;
            case 2:

                break;
            case 3:
                showStock(a);
                break;
            default:
                System.exit(0);
        }
    }


}
