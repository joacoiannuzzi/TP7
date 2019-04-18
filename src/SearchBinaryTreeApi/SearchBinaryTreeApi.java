package SearchBinaryTreeApi;

import BinaryTree.DynamicQueue;
import SearchBinaryTree.LinkedList;
import SearchBinaryTree.SearchBinaryTree;

import java.util.ArrayList;

public class SearchBinaryTreeApi<T>{

    public SearchBinaryTree<T> importListData(LinkedList<T> list){
        SearchBinaryTree<T> searchBinaryTree = new SearchBinaryTree<T>();

        for (int i = 0; i < list.getSize(); i++) {
            searchBinaryTree.insert((Comparable<T>) list.getAtPosition(i));
        }

        return searchBinaryTree;
    }

     //recorre el arbol por niveles
    public void perlevel(SearchBinaryTree<T> a) {
        if (a.isEmpty())
            return;
        ArrayList listRoot = new ArrayList();
        DynamicQueue<SearchBinaryTree<T>> queueTree = new DynamicQueue();
        queueTree.enqueue(a);

        while(!queueTree.isEmpty()){
            listRoot.add(makeQueue(queueTree));
        }

        for (Object o : listRoot) {
            System.out.print(o + " ");
        }
    }

    private T makeQueue(DynamicQueue<SearchBinaryTree<T>> queue) {
        if(!queue.peek().getLeft().isEmpty())
            queue.enqueue(queue.peek().getLeft());

        if(!queue.peek().getRight().isEmpty())
            queue.enqueue(queue.peek().getRight());

        T t = queue.peek().getRoot();
        queue.dequeue();
        return t;
    }
}
