package BinaryTree;


public class DynamicQueue<T> implements Queue<T> {

    private Node<T> front;
    private Node<T> back;
    private int size;

    @Override
    public void enqueue(T element) {
        Node<T> node = new Node<>(element);
        if (isEmpty())
            front = node;
        else
            back.setNext(node);
        back = node;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            return null;
        T temp = front.getData();
        front = front.getNext();
        size--;
        if (isEmpty())
            back = null;
        return temp;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T peek() {
        if (isEmpty())
            return null;
        return front.getData();
    }
}
