/**
 * Queue implementation using MyArrayList as the underlying data structure.
 * Follows FIFO (First In, First Out) principle.
 * @param <T> the type of elements in the queue
 */


public class MyQueue<T extends Comparable<T>> {
    private MyList<T> list;
    public MyQueue() {
        list = new MyArrayList<>();
    }

    public void enqueue(T item) {
        list.add(item);
    }
    public T dequeue() {
        return list.remove(0);
    }
    public T front() {
        return list.get(0);
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public int size () {
        return list.size();
    }
}
