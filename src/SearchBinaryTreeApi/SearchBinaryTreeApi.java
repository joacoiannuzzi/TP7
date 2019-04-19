package SearchBinaryTreeApi;

import BinaryTree.DynamicQueue;
import BinaryTreeApi.TreeApi;
import SearchBinaryTree.LinkedList;
import SearchBinaryTree.SearchBinaryTree;

import java.util.ArrayList;

public abstract class SearchBinaryTreeApi<T> extends TreeApi<T> {

    public SearchBinaryTree<T> importListData(LinkedList<T> list){
        SearchBinaryTree<T> searchBinaryTree = new SearchBinaryTree<T>();

        for (int i = 0; i < list.getSize(); i++) {
            searchBinaryTree.insert((Comparable<T>) list.getAtPosition(i));
        }

        return searchBinaryTree;
    }

    //recorre el arbol por niveles
    public abstract void perlevel(SearchBinaryTree<T> a);

    //recorre el arbol por inorden
    public abstract void inorder(SearchBinaryTree<T> a);

}
