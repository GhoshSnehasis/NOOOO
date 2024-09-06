import java.util.*;

public class Xenia {

    // Function to build the segment tree
    static void build(int ind, int low, int high, int arr[], int seg[], int orr) {
        if (low == high) {
            seg[ind] = arr[low];
            return;
        }

        int mid = (low + high) / 2;
        build(2 * ind + 1, low, mid, arr, seg, 1 - orr);
        build(2 * ind + 2, mid + 1, high, arr, seg, 1 - orr);

        // Update the segment tree with OR or XOR based on current level
        if (orr == 1)
            seg[ind] = seg[2 * ind + 1] | seg[2 * ind + 2];
        else
            seg[ind] = seg[2 * ind + 1] ^ seg[2 * ind + 2];
    }

    // Function to update the segment tree
    static void update(int ind, int low, int high, int seg[], int orr, int i, int val) {
        if (low == high) {
            seg[ind] = val; // Update the leaf node
            return;
        }

        int mid = (low + high) / 2;
        if (i <= mid)
            update(2 * ind + 1, low, mid, seg, 1 - orr, i, val);
        else
            update(2 * ind + 2, mid + 1, high, seg, 1 - orr, i, val);

        // After updating the leaf, update the internal nodes
        if (orr == 1)
            seg[ind] = seg[2 * ind + 1] | seg[2 * ind + 2];
        else
            seg[ind] = seg[2 * ind + 1] ^ seg[2 * ind + 2];
    }

    static void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int el = (int) Math.pow(2, n); // Total number of elements in the array

        int arr[] = new int[el]; // Array to store initial values
        for (int i = 0; i < el; i++) {
            arr[i] = sc.nextInt();
        }

        int seg[] = new int[4 * el]; // Segment tree array

        // Build the segment tree, starting with OR if n is odd, XOR if n is even
        if (n % 2 == 0) {
            build(0, 0, el - 1, arr, seg, 0); // XOR at the root level
        } else {
            build(0, 0, el - 1, arr, seg, 1); // OR at the root level
        }

        // Process queries
        while (q-- > 0) {
            int i = sc.nextInt();
            int val = sc.nextInt();
            i--; // Converting 1-based index to 0-based

            // Update the segment tree
            if (n % 2 == 0) {
                update(0, 0, el - 1, seg, 0, i, val); // XOR at root level
            } else {
                update(0, 0, el - 1, seg, 1, i, val); // OR at root level
            }

            // Output the root of the segment tree (result after update)
            System.out.println(seg[0]);
        }
        sc.close();
    }

    public static void main(String args[]) {
        solve();
    }
}
