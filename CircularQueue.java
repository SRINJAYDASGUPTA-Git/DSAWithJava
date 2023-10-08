import java.util.ArrayList;

public class CircularQueue<T> {
    ArrayList<T> queue = new ArrayList<>();
    int front, rear, size;
    public CircularQueue(int size){
        this.size = size;
        front = rear = -1;
    }

    public void enQueue(T data)throws OverflowException{
        if(rear == size - 1 && front == 0)
            throw new OverflowException();
        else if(isEmpty()){
            front = rear = 0;
        }
        else if(rear == size-1 && front != 0)
            rear = 0;
        else
            rear ++;
        queue.add(data);

    }

    public T deQueue() throws UnderflowException{
        T popped = queue.get(front);
        if(isEmpty())
            throw new UnderflowException();
        else if(front == size-1)
            front = 0;
        else if(front  == rear)
            front = rear = -1;
        else
            front = front + 1;
        return popped;
    }

    public void display(){
        if(front > rear){
            for(int i = front; i<size; i++)
                System.out.print(queue.get(i)+" ");
            for(int i = 0; i<=rear; i++)
                System.out.print(queue.get(i)+" ");
        }
        else
        {
            for(int i = front; i<=rear; i++)
            System.out.print(queue.get(i)+" ");
        }
        System.out.println();
    }

    public boolean isEmpty(){
        return(front == -1 && rear == -1);
    }
    
}
