/**
 * Test class to verify all implementations.
 * Contains test cases for MyArrayList, MyLinkedList, MyStack, MyQueue, and MyMinHeap.
 */


public class Main {
    public static void main(String[] args) {
        System.out.println("=== Testing MyArrayList ===\n");

        MyArrayList<String> list = new MyArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println("After adds: " + list.get(0) + ", " + list.get(1) + ", " + list.get(2));
        System.out.println("Size: " + list.size());

        list.add(1, "Date");
        System.out.println("After insert at index 1: " + list.get(0) + ", " + list.get(1) + ", " + list.get(2) + ", " + list.get(3));

        list.remove(2);
        System.out.println("After remove index 2: " + list.get(0) + ", " + list.get(1) + ", " + list.get(2));

        list.remove("Apple");
        System.out.println("After remove 'Apple': " + list.get(0) + ", " + list.get(1));

        System.out.println("Is empty? " + list.isEmpty());
        list.clear();
        System.out.println("After clear, size: " + list.size());

        System.out.println("\n=== Testing MyLinkedList ===\n");

        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        System.out.println("Get index 1: " + linkedList.get(1));
        linkedList.add(1, 15);
        System.out.println("After insert at 1: " + linkedList.get(0) + ", " + linkedList.get(1) + ", " + linkedList.get(2) + ", " + linkedList.get(3));
        linkedList.remove(2);
        System.out.println("After remove index 2: " + linkedList.get(0) + ", " + linkedList.get(1) + ", " + linkedList.get(2));

        System.out.println("\n=== Testing MyStack ===\n");

        MyStack<String> stack = new MyStack<>();
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());

        System.out.println("\n=== Testing MyQueue ===\n");

        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Front: " + queue.front());
        System.out.println("Size: " + queue.size());

        System.out.println("\n=== Testing MyMinHeap ===\n");

        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.add(50);
        heap.add(30);
        heap.add(70);
        heap.add(20);
        heap.add(40);
        System.out.println("Peek (smallest): " + heap.peek());
        System.out.println("Remove min: " + heap.removeMin());
        System.out.println("New peek: " + heap.peek());
        System.out.println("Size: " + heap.size());


        System.out.println("Exists 'Cherry'? " + list.exists("Cherry"));
        System.out.println("Exists 'Mango'? " + list.exists("Mango"));


        list.add("Banana");
        System.out.println("Last index of 'Banana': " + list.lastIndexOf("Banana"));


        MyArrayList<Integer> numbers = new MyArrayList<>();
        numbers.add(5);
        numbers.add(1);
        numbers.add(4);
        numbers.add(2);
        numbers.add(3);
        numbers.sort();
        System.out.print("Sorted: ");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }

    }
}
