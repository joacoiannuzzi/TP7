package SearchBinaryTree;

import org.junit.Test;

import static org.junit.Assert.*;

public class LampTest {
    @Test
    public void list(){
        StockList productStock = new StockList();
        productStock.insert(new Lamp("ABCDE", "lowEfficient", 15, 30));
        productStock.printList();

    }
}