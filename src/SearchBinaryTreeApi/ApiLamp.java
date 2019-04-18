package SearchBinaryTreeApi;

import BinaryTree.DynamicQueue;
import SearchBinaryTree.Lamp;
import SearchBinaryTree.SearchBinaryTree;

import java.util.ArrayList;

public class ApiLamp extends SearchBinaryTreeApi<Lamp> {

    @Override
    public void perlevel(SearchBinaryTree<Lamp> a) {
        if (a.isEmpty())
            return;
        ArrayList<Lamp> listRoot = new ArrayList<Lamp>();
        DynamicQueue<SearchBinaryTree<Lamp>> queueTree = new DynamicQueue();
        queueTree.enqueue(a);

        while(!queueTree.isEmpty()){
            listRoot.add(makeQueue(queueTree));
        }

        for (Lamp o : listRoot) {
            o.printData();
        }
    }
}
