package treeApi;

import org.junit.Test;
import tree.BinaryTree;

import static org.junit.Assert.*;

public class TreeApiTest {

    private TreeApi<Integer> treeApi = new TreeApi<>();

    private BinaryTree<Integer> tree = new BinaryTree<>(5,
            new BinaryTree<>(1,
                    new BinaryTree<>(3),
                    new BinaryTree<>(9,
                            new BinaryTree<>(8),
                            new BinaryTree<>())),
            new BinaryTree<>(7,
                    new BinaryTree<>(6),
                    new BinaryTree<>(2)));

    private BinaryTree<Integer> tree1 = new BinaryTree<>(10,
            new BinaryTree<>(8,
                    new BinaryTree<>(3),
                    new BinaryTree<>(6,
                            new BinaryTree<>(5),
                            new BinaryTree<>())),
            new BinaryTree<>(7,
                    new BinaryTree<>(6),
                    new BinaryTree<>(3)));

    private BinaryTree<Integer> tree2 = new BinaryTree<>(8,
            new BinaryTree<>(7,
                    new BinaryTree<>(6),
                    new BinaryTree<>(9,
                            new BinaryTree<>(2),
                            new BinaryTree<>())),
            new BinaryTree<>(3,
                    new BinaryTree<>(5),
                    new BinaryTree<>(1)));

    private BinaryTree<Integer> tree3 = new BinaryTree<>(8,
            new BinaryTree<>(7,
                    new BinaryTree<>(6),
                    new BinaryTree<>(9,
                            new BinaryTree<>(2),
                            new BinaryTree<>(10))),
            new BinaryTree<>(3,
                    new BinaryTree<>(5),
                    new BinaryTree<>(1)));


    private BinaryTree<Integer> emptyTree = new BinaryTree<>();

    private BinaryTree<Integer> shortTree1 = new BinaryTree<>(9,
            new BinaryTree<>(5),
            new BinaryTree<>(4));

    private BinaryTree<Integer> shortTree2 = new BinaryTree<>(9,
            new BinaryTree<>(),
            new BinaryTree<>(4));

    @Test
    public void leaves(){
        assertEquals(2, treeApi.leaves(shortTree1));
        assertEquals(4, treeApi.leaves(tree1));
    }

    @Test
    public void sum(){
        assertEquals(18, treeApi.sum(shortTree1));
        assertEquals(48, treeApi.sum(tree1));
    }

    @Test
    public void sumMultipleOf3(){
        assertEquals(9, treeApi.sumMultiplesOf3(shortTree1));
        assertEquals(18, treeApi.sumMultiplesOf3(tree1));
    }

    @Test
    public void equals() {
        assertTrue(treeApi.equals(tree, tree));
        assertFalse(treeApi.equals(tree, tree1));
        assertTrue(treeApi.equals(emptyTree, emptyTree));
        assertFalse(treeApi.equals(shortTree2, shortTree1));
    }

    @Test
    public void isomorphic() {
        assertTrue(treeApi.isomorphic(tree, tree1));
        assertFalse(treeApi.isomorphic(emptyTree, tree1));
    }

    @Test
    public void similar() {
        assertFalse(treeApi.similar(tree, tree1));
        assertTrue(treeApi.similar(tree, tree2));
        assertFalse(treeApi.similar(tree, tree3));
    }

    @Test
    public void full() {
        assertFalse(treeApi.full(tree));
        assertFalse(treeApi.full(tree1));
        assertFalse(treeApi.full(tree2));
        assertFalse(treeApi.full(tree3));
        assertFalse(treeApi.full(emptyTree));
        assertTrue(treeApi.full(shortTree1));
    }

    @Test
    public void complete() {
        assertTrue(treeApi.complete(tree3));
        assertFalse(treeApi.complete(tree));
    }

    @Test
    public void stable() {
        assertFalse(treeApi.stable(tree2));
        assertTrue(treeApi.stable(emptyTree));
        assertTrue(treeApi.stable(shortTree1));
        assertTrue(treeApi.stable(tree1));
    }

    @Test
    public void frontier() {
        System.out.print("Frontier: ");
        treeApi.showFrontier(tree);
        System.out.println();
    }

    @Test
    public void occursTree() {
        BinaryTree<Integer> g1 = new BinaryTree<>(9,
                new BinaryTree<>(8),
                new BinaryTree<>());
        BinaryTree<Integer> g2 = new BinaryTree<>(9,
                new BinaryTree<>(8),
                new BinaryTree<>(5));
        assertTrue(treeApi.occursTree(tree, g1));
        assertFalse(treeApi.occursTree(tree, g2));
    }

    @Test
    public void preOrder(){
        System.out.print("preOrder: ");
        treeApi.preorder(tree2);
        System.out.println();

    }

    @Test
    public void inOrder(){
        System.out.print("inOrder: ");
        treeApi.inorder(tree2);
        System.out.println();

    }

    @Test
    public void postOrder(){
        System.out.print("postOrder: ");
        treeApi.postorder(tree2);
        System.out.println();

    }

    @Test
    public void perLevel(){
        System.out.print("perLevels: ");
        treeApi.perlevel(tree2);
        System.out.println();

    }

    @Test
    public void saveOnDisk(){
        treeApi.saveOnDisk(tree);
        BinaryTree<Integer> j = treeApi.getFromDisk();
        assertTrue(treeApi.equals(tree, j));
        assertFalse(treeApi.equals(tree1, j));
    }

}