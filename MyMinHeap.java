/**
 * Min-heap implementation using MyArrayList.
 * The smallest element is always at the root (index 0).
 * @param <T> the type of elements in the heap, must be Comparable
 */


public class MyMinHeap<T extends Comparable<T>> {
    private MyList<T> list;

    public MyMinHeap() {
        list = new MyArrayList<>();
    }

    private void swap(int i, int j) {
        T temp = list.get(i);
        T temp2 = list.get(j);
        list.set(i, temp2);
        list.set(j, temp);

    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (list.get(index).compareTo(list.get(parent)) < 0) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    public void add(T item) {
        list.add(item);
        heapifyUp(list.size() - 1);
    }

    public T peek() {
        if (list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    private void heapifyDown(int index) {
        int size = list.size();
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && list.get(left).compareTo(list.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < size && list.get(right).compareTo(list.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    public T removeMin() {
        if (isEmpty()) {
            return null;
        }

        T min = list.get(0);
        T last = list.get(list.size() - 1);
        list.set(0, last);
        list.remove(list.size() - 1);

        if (!isEmpty()) {
            heapifyDown(0);
        }

        return min;
    }
}