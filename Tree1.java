import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static final int N = 100010; // Constant representing the maximum number of nodes
    static ArrayList<Integer>[] adj = new ArrayList[N]; // Adjacency list for graph
    static boolean[] visited = new boolean[N]; // Array to keep track of visited nodes
    static int[][] NodeSize = new int[27][N]; // Matrix to store the sizes of nodes
    static String s; // Input string

    // Depth First Search (DFS) function
    static int dfs(int node, char c, int y) {
        visited[node] = true; // Mark node as visited
        int curr_size = (s.charAt(node - 1) == c) ? 1 : 0; // Check if current node matches the character

        // Visit all unvisited child nodes
        for (int child : adj[node]) {
            if (!visited[child]) {
                curr_size += dfs(child, c, y);
            }
        }

        NodeSize[y][node] = curr_size; // Store current size in the NodeSize matrix
        return curr_size; // Return current size
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for input
        int n = scanner.nextInt(); // Number of nodes
        int q = scanner.nextInt(); // Number of queries
        s = scanner.next(); // Input string

        // Initialize adjacency list
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        // Read edges of the graph
        for (int i = 1; i < n; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

        // Run DFS for each character from 'a' to 'z'
        for (char j = 'a'; j <= 'z'; j++) {
            int y = j - 'a' + 1; // Map character to corresponding index
            dfs(1, j, y); // Run DFS from the first node

            // Reset visited array after each DFS run
            for (int k = 0; k < visited.length; k++) {
                visited[k] = false;
            }
        }

        // Process queries
        while (q-- > 0) {
            int u = scanner.nextInt(); // Node
            char c = scanner.next().charAt(0); // Character
            System.out.println(NodeSize[c - 'a' + 1][u]); // Output the result
        }

        scanner.close(); // Close scanner
    }
}
