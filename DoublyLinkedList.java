class Node<T> {
    T data;
    Node<T> left;
    Node<T> right;

    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class DoublyLinkedList<T> {
    private Node<T> head;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void addAtBeginning(T data){
        Node<T> newNode = new Node<>(data);
        if(head == null){
            head = newNode;
        }
        else{
            newNode.right = head;
            head.left = newNode;
            head = newNode;
        }
    }

    public void addAtEnd(T data){
        Node<T> newNode = new Node<>(data);
        if(head == null){
            head = newNode;
        }
        else{
            Node<T> current = head;
            while(current.right != null){
                current = current.right;
            }
            current.right = newNode;
            newNode.left = current;
        }
    }

    public void addAtIndex(T data, int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            addAtBeginning(data);
            return;
        }
        if(index == size){
            addAtEnd(data);
            return;
        }
        Node<T> newNode = new Node<>(data);
        Node<T> current = head;
        for(int i = 0; i<index-1; i++){
            current = current.right;
        }
        newNode.right = current.right;
        current.right.left = newNode;
        current.right = newNode;
        newNode.left = current;
    }

    public void removeAtBeginning() throws UnderflowException{
        if(head == null){
            throw new UnderflowException();
        }
        else{
            head = head.right;
            head.left = null;
        }
    }

    public void removeAtEnd() throws UnderflowException{
        if(head == null){
            throw new UnderflowException();
        }
        else{
            Node<T> current = head;
            while(current.right != null){
                current = current.right;
            }
            current.left.right = null;
        }
    }

    public void removeAtIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            try {
                removeAtBeginning();
            } catch (UnderflowException e) {
                System.out.println(e.getMessage());
            }
            return;
        }
        if(index == size-1){
            try {
                removeAtEnd();
            } catch (UnderflowException e) {
                System.out.println(e.getMessage());
            }
            return;
        }
        Node<T> current = head;
        for(int i = 0; i<index-1; i++){
            current = current.right;
        }
        current.right = current.right.right;
        current.right.left = current;
    }

    public void remove(T data){
        if(head == null){
            return;
        }
        if(head.data == data){
            try {
                removeAtBeginning();
            } catch (UnderflowException e) {
                System.out.println(e.getMessage());
            }
            return;
        }
        Node<T> current = head;
        while(current.right != null){
            if(current.right.data == data){
                current.right = current.right.right;
                current.right.left = current;
                return;
            }
            current = current.right;
        }
    }

    public boolean  isEmpty(){
        return head == null;
    }
    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.right;
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        try {
            list.addAtBeginning(1);
            list.addAtBeginning(2);
            list.addAtBeginning(3);
            list.addAtBeginning(4);
            list.addAtBeginning(5);
            list.addAtEnd(6);
            list.addAtEnd(7);
            list.addAtEnd(8);
            list.addAtEnd(9);
            list.addAtIndex(10, 5);
            list.addAtIndex(11, 0);
            list.addAtIndex(12, 11);
            list.display();
            list.removeAtBeginning();
            list.removeAtEnd();
            list.removeAtIndex(5);
            list.remove(12);
            list.display();
        } catch (UnderflowException e) {
            System.out.println(e.getMessage());
        }
    }
}
