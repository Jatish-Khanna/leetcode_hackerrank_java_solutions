import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

class MyQueue<T> {
    Stack<T> firstStack = new Stack<>();
    Stack<T> secocndStack = new Stack<>();

    public void enqueue(T nextInt) {
        // TODO Auto-generated method stub
        firstStack.push(nextInt);
    }

    public T peek() {

        if (secocndStack.isEmpty()) {
            transferStackData();
            if (secocndStack.isEmpty())
                throw new NullPointerException();
        }
        return secocndStack.peek();
    }

    private void transferStackData() {
        // TODO Auto-generated method stub
        while (!firstStack.isEmpty()) {
            secocndStack.push(firstStack.pop());
        }
    }

    public void dequeue() {
        // TODO Auto-generated method stub
        if (secocndStack.isEmpty()) {
            transferStackData();
            if (secocndStack.isEmpty())
                throw new NullPointerException();

        }
        secocndStack.pop();
    }

}
