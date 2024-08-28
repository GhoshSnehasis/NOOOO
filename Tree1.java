/*You are given a rooted tree that contains 
 nodes. Each node contains a lowercase alphabet.

You are required to answer 
 queries of type 
, where 
 is an integer and 
 is a lowercase alphabet. The count of nodes in the subtree of the node 
 containing 
 is considered as the answer of all the queries. 

Input format

First line: Two space-separated integers 
 respectively
Second line: A string 
 of length 
 (where the 
 character of 
 represents the character stored in node 
)
Next 
 line: Two space-separated integers 
 and 
 denoting an edge between node 
 and node 
Next 
 lines: An integer 
 and a space-separated character 
 
Output format
For each query, print the output in a new line. 

Constraints


 is a lowercase alphabet
 is a lowercase alphabet for all 
 is the root node
Note: It is guaranteed that the input generates a valid tree.

Sample Input
3 1
aba
1 2
1 3
1 a
Sample Output
2
Time Limit: 1
Memory Limit: 256
Source Limit:
Explanation
Tree given in the sample input will look like that.*/



Number of nodes in the subtree of node 1 having 'a' stored in it is 2. 
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
