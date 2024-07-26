import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[k];
            for(int i = 0;i < k;i++)
                arr[i] = sc.nextInt();
            Arrays.sort(arr);
            long ops = 0;
            for(int i = 0;i < k - 1;i++)
                ops += 2 * arr[i] - 1;
            System.out.println(ops);
        }
    }
}