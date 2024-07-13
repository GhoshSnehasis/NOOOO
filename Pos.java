import java.util.*;

public class Divide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();
        List<Integer> zero = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                neg.add(arr[i]);
            } else if (arr[i] > 0) {
                pos.add(arr[i]);
            } else {
                zero.add(arr[i]);
            }
        }

        // Adjust to ensure each set meets the requirement
        List<Integer> set1 = new ArrayList<>();
        List<Integer> set2 = new ArrayList<>();
        List<Integer> set3 = new ArrayList<>();

        // Ensure the first set (product < 0) has at least one negative number
        set1.add(neg.remove(neg.size() - 1));

        // Ensure the second set (product > 0) has at least one positive number
        if (!pos.isEmpty()) {
            set2.add(pos.remove(0));
        } else {
            set2.add(neg.remove(neg.size() - 1));
            set2.add(neg.remove(neg.size() - 1));
        }

        // All remaining elements go to the third set (product == 0)
        set3.addAll(zero);
        
        if (!neg.isEmpty()) {
            set3.addAll(neg);
        }

        if (!pos.isEmpty()) {
            set3.addAll(pos);
        }

        // Output the sets
        System.out.println(set1.size() + " " + String.join(" ", set1.stream().map(String::valueOf).toArray(String[]::new)));
        System.out.println(set2.size() + " " + String.join(" ", set2.stream().map(String::valueOf).toArray(String[]::new)));
        System.out.println(set3.size() + " " + String.join(" ", set3.stream().map(String::valueOf).toArray(String[]::new)));
        
        sc.close();
    }
}
