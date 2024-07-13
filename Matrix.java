import java.util.*;

public class ProgressiveSquareChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int testCase = 0; testCase < t; testCase++) {
            int n = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            int[] b = new int[n * n];
            
            for (int i = 0; i < n * n; i++) {
                b[i] = sc.nextInt();
            }

            // Sort the array b
            Arrays.sort(b);

            // Generate the smallest possible progressive square starting from the smallest element in b
            int a11 = b[0];
            int[][] progressiveSquare = new int[n][n];
            progressiveSquare[0][0] = a11;
            
            // Fill the first row and first column
            for (int i = 1; i < n; i++) {
                progressiveSquare[i][0] = progressiveSquare[i - 1][0] + c;
                progressiveSquare[0][i] = progressiveSquare[0][i - 1] + d;
            }
            
            // Fill the rest of the square
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    progressiveSquare[i][j] = progressiveSquare[i - 1][j] + c;
                }
            }

            // Extract elements from the progressive square and sort them
            int[] progressiveElements = new int[n * n];
            int index = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    progressiveElements[index++] = progressiveSquare[i][j];
                }
            }
            Arrays.sort(progressiveElements);

            // Check if sorted b matches the sorted progressiveElements
            boolean isValid = Arrays.equals(b, progressiveElements);

            System.out.println(isValid ? "YES" : "NO");
        }

        sc.close();
    }
}
