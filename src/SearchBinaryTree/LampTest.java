package SearchBinaryTree;

import org.junit.Test;

import static org.junit.Assert.*;

public class LampTest {
    @Test
    public void list(){
        StockList productStock = new StockList();
        productStock.insert(new Lamp("ABCDE", "lowEfficient", 15, 30));
        productStock.insert(new Lamp("ADEJF", "medEfficient", 17, 7));
        productStock.insert(new Lamp("DEFDD", "highEfficient", 20, 24));
        productStock.printList();

    }
}