package SearchBinaryTreeApi;

import BinaryTree.DynamicQueue;
import BinaryTreeApi.Tree;
import SearchBinaryTree.Lamp;
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

    public void remove(SearchBinaryTree<Lamp> a, String code) {
        Lamp lamp = new Lamp(code);
        a.remove(lamp);
    }

    public void modifyAmount(SearchBinaryTree<Lamp> a, String code, int q) {
        Lamp lamp = new Lamp(code);
        a.search(lamp).setAmount(q);
    }

    public void modifyType(SearchBinaryTree<Lamp> a, String code, String type) {
        Lamp lamp = new Lamp(code);
        a.search(lamp).setLampType(type);
    }

    public void modifyWatts(SearchBinaryTree<Lamp> a, String code, int watts) {
        Lamp lamp = new Lamp(code);
        a.search(lamp).setLampWatts(watts);
    }

    public void showStock(SearchBinaryTree<Lamp> a) {
        inorder(a);
    }



    public void options(SearchBinaryTree<Lamp> a){

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Options: ");
            System.out.println("0 -> Add a Lamp");
            System.out.println("1 -> Remove a Lamp");
            System.out.println("2 -> Modify a Lamp");
            System.out.println("3 -> Show stock");
            System.out.println("4 -> Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 0:
                    System.out.println("Enter a: lampCode, lampType, lampWatts, lampAmount");
                    Lamp lamp = new Lamp(scanner.next().toUpperCase(), scanner.next(), scanner.nextInt(), scanner.nextInt());
                    insert(a, lamp);
                    break;
                case 1:
                    System.out.println("Enter a lampCode to remove: ");
                    remove(a, scanner.next().toUpperCase());
                    break;
                case 2:
                    System.out.println("Enter a lampCode to modify: ");
                    String code = scanner.next().toUpperCase();

                    System.out.println("Enter an option: ");
                    int o = 0;
                    while (o != 3) {
                        System.out.println("0 -> Change amount");
                        System.out.println("1 -> Change type");
                        System.out.println("2 -> Change watts");
                        System.out.println("3 -> Exit");
                        o = scanner.nextInt();
                        switch (o) {
                            case 0:
                                System.out.println("Enter an Amount: ");
                                modifyAmount(a, code, scanner.nextInt());
                                break;
                            case 1:
                                System.out.println("Enter a Type: ");
                                modifyType(a, code, scanner.next());
                                break;
                            case 2:
                                System.out.println("Enter Watts: ");
                                modifyWatts(a, code, scanner.nextInt());
                                break;
                            case 3:
                                o = 3;
                        }
                    }
                    break;
                case 3:
                    showStock(a);
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }


}
