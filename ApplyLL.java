import java.util.Scanner;

public class ApplyLL {

    public static int min(LinkedList<Integer> ll){
        int min = ll.get(0);
        for(int i = 0; i<ll.size(); i++)
            if(min > ll.get(i))
                min = ll.get(i);
        return min;
    }
    
    public static int max(LinkedList<Integer> ll){
        int max = ll.get(0);
        for(int i = 0; i < ll.size(); i++)
            if(max < ll.get(i))
                max = ll.get(i);
        return max;
    }

    public static int sum(LinkedList<Integer> ll){
        int sum = 0;
        for(int i = 0; i<ll.size(); i++)
            sum += ll.get(i);
        return sum;
    }

    public void binarySearch(LinkedList<Integer> ll, int ele){
        int l = 0, u = ll.size()-1,mid;
        while(l<=u){
            mid = (l+u)/2;
            if(ll.get(mid) == ele){
                System.out.println("Element found at index "+mid);
                return;
            }
            else if(ll.get(mid) < ele)
                l = mid + 1;
            else
                u = mid - 1;
        }
    }

    public void linearSearch(LinkedList<Integer> ll, int ele){
        for(int i = 0; i<ll.size(); i++){
            if(ll.get(i) == ele){
                System.out.println("Element found at index "+i);
                return;
            }
        }
    }

    public static void selectionSort(LinkedList<Integer> ll){
        int min = 0;
        for(int i = 0; i<ll.size(); i++){
            min = i;
            for(int j = i+1; j<ll.size(); j++){
                if(ll.get(j)<ll.get(min))
                    min = j;
            }
            int temp = ll.get(i);
            ll.set(i, ll.get(min));
            ll.set(min, temp);
        }
    }
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        int size; 
        System.out.println("Enter the size of the list");
        size = in.nextInt();
        System.out.println("Enter the elements of the list");
        for(int i = 0; i<size; i++){
            ll.add(in.nextInt());
        }
        System.out.println("the current list: ");
        ll.display();
        System.out.println("");
        selectionSort(ll);
        System.out.println("the sorted list: ");
        ll.display();
        System.out.println("The minimum element: "+min(ll));
        System.out.println("The maximum element: "+max(ll));
        System.out.println("The sum of all elements: "+sum(ll));
        in.close();
    }
}
