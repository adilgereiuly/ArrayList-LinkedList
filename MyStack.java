/**
 * Stack implementation using MyArrayList as the underlying data structure.
 * Follows LIFO (Last In, First Out) principle.
 * @param <T> the type of elements in the stack
 */


public class MyStack<T extends Comparable<T>> {
    private MyList<T> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    public void push(T item) {
         list.add(item);
    }
    public T pop() {
        return list.remove(list.size()-1);

    }
    public T peek() {
        return list.get(list.size()-1);
    }
    public boolean isEmpty () {
        return list.isEmpty();
    }
    public int size () {
        return list.size();
    }



}
