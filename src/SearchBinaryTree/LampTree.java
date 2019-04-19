package SearchBinaryTree;

public class LampTree extends SearchBinaryTree<Lamp> {

    public Lamp search(String code) {
        return search(root, code).elem;
    }

    public DoubleNode<Lamp> search(DoubleNode<Lamp> t, String code) {
        if (t == null)
            throw new RuntimeException("Not found");
        if(code.equals(t.elem.getLampCode())){
            return t;
        }else if(code.compareTo(t.elem.getLampCode()) < 0){
            return search(t.left, code);
        } else {
            return search(t.right, code);
        }
    }
}
