package BinaryTreeApi;

import BinaryTree.BinaryTree;
import BinaryTree.DynamicQueue;

import java.io.*;
import java.util.ArrayList;

public class TreeApi<T> {

    //cantidad de elementos que tiene
    public int size(BinaryTree<T> a) {
        if (a.isEmpty())
            return 0;
        return 1 + size(a.getLeft()) + size(a.getRight());
    }

    //cantidad de hojas
    public int leaves(BinaryTree<T> a) { 
        if (a.isEmpty())
            return 0;
        if (a.getRight().isEmpty() && a.getLeft().isEmpty())
            return 1;
        return leaves(a.getRight()) + leaves(a.getLeft());
    }

    //cantidad de veces que aparece el elemento
    public int occurrences(BinaryTree<T> a, T o) {
        if (a.isEmpty())
            return 0;
        if (a.getRoot().equals(o))
            return 1 + occurrences(a.getRight(), o) + occurrences(a.getLeft(), o);
        return occurrences(a.getRight(), o) + occurrences(a.getLeft(), o);
    }

    //cantidad de elementos que hay por nivel
    public int elementsAtLevel(BinaryTree<T> a, int level) {
        if (a.isEmpty())
            return 0;
        if (level == 0)
            return 1;
        return elementsAtLevel(a.getLeft(), level - 1) + elementsAtLevel(a.getRight(), level - 1);
    }

    //la altura maxima del arbol
    public int height(BinaryTree<T> a) {
        int position = 0;
        while (elementsAtLevel(a, position) != 0) {
            position++;
        }
        return position - 1;
    }

    //suma de un arbol de enteros
    public int sum(BinaryTree<Integer> a) {
        if (a.isEmpty())
            return 0;
        return a.getRoot() + sum(a.getRight()) + sum(a.getLeft());
    }

    //suma de un arbol de enteros si son multiplos de 3
    public int sumMultiplesOf3(BinaryTree<Integer> a) {
        if (a.isEmpty())
            return 0;
        if (a.getRoot() % 3 == 0)
            return a.getRoot() + sumMultiplesOf3(a.getRight()) + sumMultiplesOf3(a.getLeft());
        return sumMultiplesOf3(a.getRight()) + sumMultiplesOf3(a.getLeft());
    }

    //si 2 arboles son iguales
    public boolean equals(BinaryTree<T> a, BinaryTree<T> b) {
        if (size(a) != size(b))
            return false;
        if (a.isEmpty())
            return b.isEmpty();
        if (b.isEmpty())
            return false;
        if (!a.getRoot().equals(b.getRoot()))
            return false;
        return equals(a.getLeft(), b.getLeft()) && equals(a.getRight(), b.getRight());
    }

    // si 2 arboles tienen la misma forma
    public boolean isomorphic(BinaryTree<T> a, BinaryTree<T> b) {
        if (size(a) != size(b))
            return false;
        if (a.isEmpty())
            return b.isEmpty();
        if (b.isEmpty())
            return a.isEmpty();
        return isomorphic(a.getRight(), b.getRight()) && isomorphic(a.getLeft(), b.getLeft());
    }

    // una lista con los elementos del arbol
    public ArrayList<T> treeToList(BinaryTree<T> a){
        ArrayList<T> list = new ArrayList<>();
        addToList(a, list);
        return list;
    }

    private void addToList(BinaryTree<T> a, ArrayList<T> list) {
        if (a.isEmpty())
            return;
        list.add(a.getRoot());
        addToList(a.getLeft(), list);
        addToList(a.getRight(), list);
    }

    //si 2 arboles son similares
    public boolean similar(BinaryTree<T> a, BinaryTree<T> b) {
        if (size(a) != size(b))
            return false;
        for (T t : treeToList(a)) {
            if (occurrences(a, t) != occurrences(b, t))
                return false;
        }
        return true;
    }

    //indica si el arbol esta completo
    public boolean complete(BinaryTree<T> a) {
        if(a.isEmpty())
            return false;
        if(a.getLeft().isEmpty())
            return a.getRight().isEmpty();
        if(a.getRight().isEmpty())
            return a.getLeft().isEmpty();
        return complete(a.getLeft()) && complete(a.getRight());
    }

    //indica si el arbol esta lleno
    public boolean full(BinaryTree<T> a) {
        if (a.isEmpty())
            return false;
        int h = height(a);
        return elementsAtLevel(a, h) == Math.pow(2, h);
    }

    //indica si el arbol es estable
    public boolean stable(BinaryTree<Integer> a) {
        if (size((BinaryTree<T>) a) <= 1)
            return true;
        if (!a.getLeft().isEmpty()) {
            if (a.getRoot() <= a.getLeft().getRoot())
                return false;
        }
        if (!a.getRight().isEmpty()) {
            if (a.getRoot() <= a.getRight().getRoot())
                return false;
        }
        return stable(a.getLeft()) && stable(a.getRight());
    }

    public boolean occursTree(BinaryTree<T> a, BinaryTree<T> b) {
        if (size(b) > size(a))
            return false;
        if (b.isEmpty())
            return true;
        if(a.isEmpty())
            return false;
        if (occurs(a, b))
            return true;
        return occursTree(a.getLeft(), b) || occursTree(a.getRight(), b);
    }

    private boolean occurs(BinaryTree<T> a, BinaryTree<T> b) {
        if (a.isEmpty())
            return b.isEmpty();
        if (b.isEmpty())
            return true;
        if (!a.getRoot().equals(b.getRoot()))
            return false;
        return occurs(a.getLeft(), b.getLeft()) && occurs(a.getRight(), b.getRight());
    }

    //imprime la frontera del arbol binario
    public void showFrontier(BinaryTree<T> a) {
        for (T t : frontier(a)) {
            System.out.print(t + " ");
        }
    }

    //devuelve un ArrayList con la frontera del arbol binario
    public ArrayList<T> frontier(BinaryTree<T> a) {
        ArrayList<T> list = new ArrayList<>();
        addFrontierList(a, list);
        return list;
    }

    //añade la frontera a un ArrayList
    private void addFrontierList(BinaryTree<T> a, ArrayList<T> list) {
        if (a.isEmpty())
            return;
        if (a.getLeft().isEmpty() && a.getRight().isEmpty())
            list.add(a.getRoot());
        addFrontierList(a.getLeft(), list);
        addFrontierList(a.getRight(), list);
    }

    //recorre el arbol por preorden
    public void preorder(BinaryTree<T> a) {
        if (!a.isEmpty()) {
            System.out.print(a.getRoot() + " ");
            preorder(a.getLeft());
            preorder(a.getRight());
        }
    }

    //recorre el arbol por inorden
    public void inorder(BinaryTree<T> a) {
        if (!a.isEmpty()) {
            inorder(a.getLeft());
            System.out.print(a.getRoot() + " ");
            inorder(a.getRight());
        }
    }

    //recorre el arbol por postorden
    public void postorder(BinaryTree<T> a) {
        if (!a.isEmpty()) {
            postorder(a.getLeft());
            postorder(a.getRight());
            System.out.print(a.getRoot() + " ");
        }
    }

    //recorre el arbol por niveles
    public void perlevel(BinaryTree<T> a) {
        if (a.isEmpty())
            return;
        ArrayList listRoot = new ArrayList();
        DynamicQueue<Tree<T>> queueTree = new DynamicQueue();
        queueTree.enqueue(a);

        while(!queueTree.isEmpty()){
            listRoot.add(makeQueue(queueTree));
        }

        for (Object o : listRoot) {
            System.out.print(o + " ");
        }
    }

    public T makeQueue(DynamicQueue<Tree<T>> queue) {
        if(!queue.peek().getLeft().isEmpty())
            queue.enqueue(queue.peek().getLeft());

        if(!queue.peek().getRight().isEmpty())
            queue.enqueue(queue.peek().getRight());

        T t = queue.peek().getRoot();
        queue.dequeue();
        return t;
    }

    //salva en disco al arbol binario
    public void saveOnDisk(BinaryTree<T> a) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    new FileOutputStream(new File("BinaryTreeFile")));
            outputStream.writeObject(a);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //recupera del disco el arbol binario
    public BinaryTree<T> getFromDisk() {
        BinaryTree<T> binaryTree = null;
        try {
            ObjectInputStream inputStream = new ObjectInputStream(
                    new FileInputStream(new File("BinaryTreeFile")));
            binaryTree = (BinaryTree<T>) inputStream.readObject();
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return binaryTree;
    }
}
