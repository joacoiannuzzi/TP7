package SearchBinaryTreeApi;

import BinaryTree.DynamicQueue;
import SearchBinaryTree.LinkedList;
import SearchBinaryTree.SearchBinaryTree;

import java.util.ArrayList;

public abstract class SearchBinaryTreeApi<T>{

    public SearchBinaryTree<T> importListData(LinkedList<T> list){
        SearchBinaryTree<T> searchBinaryTree = new SearchBinaryTree<T>();

        for (int i = 0; i < list.getSize(); i++) {
            searchBinaryTree.insert((Comparable<T>) list.getAtPosition(i));
        }

        return searchBinaryTree;
    }

     //recorre el arbol por niveles
    public abstract void perlevel(SearchBinaryTree<T> a);

    public T makeQueue(DynamicQueue<SearchBinaryTree<T>> queue) {
        if(!queue.peek().getLeft().isEmpty())
            queue.enqueue(queue.peek().getLeft());

        if(!queue.peek().getRight().isEmpty())
            queue.enqueue(queue.peek().getRight());

        T t = queue.peek().getRoot();
        queue.dequeue();
        return t;
    }
}
