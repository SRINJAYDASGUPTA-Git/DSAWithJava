import java.util.*;
public class Queue<T> {
    ArrayList<T> queue = new ArrayList<>();
    int front, rear, size;
    public Queue(int size){
        this.size = size;
        front = rear = -1;
    }

    public void enQueue(T data)throws OverflowException{
        if(rear == size - 1)
            throw new OverflowException();
        else if(isEmpty()){
            front = rear = 0;
        }
        else
            rear ++;
        queue.add(data);

    }

    public T deQueue() throws UnderflowException{
        T popped = queue.get(front);
        if(isEmpty())
            throw new UnderflowException();
        else if(front == rear)
            front = rear = -1;
        else
            front = front + 1;
        return popped;
    }

    public void display(){
        for(int i = front; i<=rear; i++)
            System.out.print(queue.get(i)+" ");
        System.out.println();
    }

    public boolean isEmpty(){
        return(front == -1 && rear == -1);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(5);
        try {
            queue.enQueue(1);
            queue.enQueue(2);
            queue.enQueue(3);
            queue.enQueue(4);
            queue.display();
            System.out.println(queue.deQueue());
            System.out.println(queue.deQueue());
            queue.display();
        } catch (OverflowException e) {
            System.out.println("Queue is full");
        } catch (UnderflowException e) {
            System.out.println("Queue is empty");
        }
    }
}