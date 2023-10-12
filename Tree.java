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

public class Tree<T> {
    private Node<T> root;

    public Tree(){
        this.root = null;
    }
    //    add method to insert a new node in the tree
    public void add(T data){
        Node<T> newNode = new Node<>(data);
        if(root == null){
            root = newNode;
        }
        else{
            Node<T> current = root;
            Node<T> parent;
            while(true){
                parent = current;
                if((int)data < (int)current.data){
                    current = current.left;
                    if(current == null){
                        parent.left = newNode;
                        return;
                    }
                }
                else{
                    current = current.right;
                    if(current == null){
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }
    //    method to display the tree
    public void display(){
        display(root);
    }

    private void display(Node<T> root){
        if(root != null){
            display(root.left);
            System.out.print(" " + root.data);
            display(root.right);
        }
    }
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.add(50);
        tree.add(25);
        tree.add(15);
        tree.add(30);
        tree.add(75);
        tree.add(85);
        tree.add(65);
        tree.display();
    }

}
