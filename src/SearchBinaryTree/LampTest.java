package SearchBinaryTree;

import SearchBinaryTreeApi.ApiLamp;
import SearchBinaryTreeApi.SearchBinaryTreeApi;
import org.junit.Test;

import static org.junit.Assert.*;

public class LampTest {
    @Test
    public void list(){
        StockList productStock = new StockList();
        productStock.insert(new Lamp("ABCDE", "lowEfficient", 15, 30));
        productStock.insert(new Lamp("ADEJF", "medEfficient", 17, 7));
        productStock.insert(new Lamp("DEFDD", "highEfficient", 20, 24));

        productStock.getAtPosition(0).printData();
        productStock.getAtPosition(1).printData();
        productStock.getAtPosition(2).printData();

    }

    @Test
    public void treeTest(){
        SearchBinaryTree<Lamp> searchBinaryTree = new SearchBinaryTree<Lamp>();
        searchBinaryTree.insert(new Lamp("ABCDE", "lowEfficient", 15, 30));
        searchBinaryTree.insert(new Lamp("ADEJF", "medEfficient", 17, 7));
        searchBinaryTree.insert(new Lamp("DEFDD", "highEfficient", 20, 24));

        SearchBinaryTreeApi searchBinaryTreeApi = new ApiLamp();
        searchBinaryTreeApi.perlevel(searchBinaryTree);
    }

//    @Test
//    public void importTest(){
//        StockList productStock = new StockList();
//        productStock.insert(new Lamp("ABCDE", "lowEfficient", 15, 30));
//        productStock.insert(new Lamp("ABERE", "dEfficient", 8, 7));
//        productStock.insert(new Lamp("SAPEE", "oP_Efficient", 17, 7));
//        productStock.insert(new Lamp("DEFDD", "highEfficient", 20, 24));
//        productStock.insert(new Lamp("ADEJF", "medEfficient", 7, 7));
//
//
//        ApiLamp searchBinaryTreeApi = new ApiLamp();
//
//        SearchBinaryTree<Lamp> searchBinaryTree = searchBinaryTreeApi.importListData(productStock);
//
//        searchBinaryTreeApi.inorder(searchBinaryTree);
//    }

    public static void main(String[] args) {
        StockList productStock = new StockList();
        productStock.insert(new Lamp("ABCDE", "lowEff", 15, 30));
        productStock.insert(new Lamp("ABERE", "dEff", 8, 7));
        productStock.insert(new Lamp("SAPEE", "oP_Eff", 17, 7));
        productStock.insert(new Lamp("DEFDD", "highEff", 20, 24));
        productStock.insert(new Lamp("ADEJF", "medEff", 7, 7));

        ApiLamp searchBinaryTreeApi = new ApiLamp();

        SearchBinaryTree<Lamp> searchBinaryTree = searchBinaryTreeApi.importListData(productStock);

        searchBinaryTreeApi.inorder(searchBinaryTree);

        searchBinaryTreeApi.options(searchBinaryTree);

        searchBinaryTreeApi.inorder(searchBinaryTree);
    }
}