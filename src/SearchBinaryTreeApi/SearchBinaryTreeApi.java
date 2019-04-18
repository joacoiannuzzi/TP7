package SearchBinaryTreeApi;

import SearchBinaryTree.LinkedList;
import SearchBinaryTree.SearchBinaryTree;

public class SearchBinaryTreeApi<T>{

    public SearchBinaryTree<T> importListData(LinkedList<T> list){
        SearchBinaryTree<T> searchBinaryTree = new SearchBinaryTree<T>();

        for (int i = 0; i < list.getSize(); i++) {
            searchBinaryTree.insert((Comparable<T>) list.getAtPosition(i));
        }

        return searchBinaryTree;
    }
}
