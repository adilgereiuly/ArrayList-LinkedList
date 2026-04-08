/**
 * Doubly linked list implementation of MyList.
 * Each node contains references to both next and previous nodes.
 * @param <T> the type of elements in the list
 */

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    private static class MyNode<T> {
        T data;
        MyNode<T> next;
        MyNode<T> prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        MyNode<T> variable = head;
        for (int i = 0; i < index; i++) {
            variable = variable.next;
        }
        return variable;


    }


    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, T item) {
        MyNode<T> newNode = new MyNode<>(item);

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            if (size == 0) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            size++;
        } else if (index == size) {
            add(item);
        } else {
            MyNode<T> prevNode = getNode(index - 1);
            MyNode<T> nextNode = prevNode.next;
            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = nextNode;
            nextNode.prev = newNode;
            size++;


        }


    }

    public T get(int index) {
        return getNode(index).data;
    }

    public T remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();

        }
        MyNode<T> removedNode = getNode(index);

        if (index == 0) {
            if (size == 1) {
                tail = null;
                head = null;
            }
            else { head = head.next;
            head.prev = null; }

        } else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            MyNode<T> prevNode = getNode(index - 1);
            MyNode<T> nextNode = getNode(index + 1);
            prevNode.next = nextNode;
            nextNode.prev = prevNode;


        }
        size--;
        return removedNode.data;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;

    }


    public boolean remove(T item) {
        MyNode<T> iteratingNode = head;
        for (int i = 0; i < size; i++) {
            if (iteratingNode.data.equals(item)) {
                remove(i);
                return true;
            }
            iteratingNode = iteratingNode.next;

        }

        return false;
    }

    public T set(int index, T item) {
        MyNode<T> node = getNode(index);
        T old = node.data;
        node.data = item;
        return old;
    }

    public void sort() {

        Object[] arr = toArray();


        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                T current = (T) arr[j];
                T next = (T) arr[j + 1];
                if (current.compareTo(next) > 0) {
                    Object temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }


        clear();
        for (Object item : arr) {
            add((T) item);
        }
    }


    public int indexOf(Object item) {
        MyNode<T> current = head;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(item)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }


    public int lastIndexOf(Object item) {
        MyNode<T> current = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (current.data.equals(item)) {
                return i;
            }
            current = current.prev;
        }
        return -1;
    }


    public boolean exists(Object item) {
        return indexOf(item) != -1;
    }


    public Object[] toArray() {
        Object[] result = new Object[size];
        MyNode<T> current = head;
        for (int i = 0; i < size; i++) {
            result[i] = current.data;
            current = current.next;
        }
        return result;
    }
}
