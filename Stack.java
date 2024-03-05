import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> stack = new ArrayList<>();
    private int top, size;

    public Stack(int size) {
        top = -1;
        this.size = size;
    }

    public void push(T data) throws OverflowException {
        if (top == size - 1) {
            throw new OverflowException();
        }
        stack.add(data);//stack[++top] = data
        top++;
    }

    public T pop() throws UnderflowException {
        if (top == -1) {
            throw new UnderflowException();
        }
        T data = stack.get(top);//stack[top--]
        top--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return stack.get(top);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return size;
    }

    public void display() {
        for (int i = 0; i <= top; i++) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(5);
        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.display();
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            stack.display();
            stack.push(5);
            stack.push(6);
            stack.push(7);
            stack.push(8);
            stack.push(9);
            stack.display();
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            stack.display();
        } catch (OverflowException e) {
            System.out.println(e.getMessage());
        } catch (UnderflowException e) {
            System.out.println(e.getMessage());
        }
    }

}
