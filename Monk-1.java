import java.util.Scanner;

public class MaxBananas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();  // Number of test cases

        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            // Maximum product initialized to current product
            int maxProduct = a * b * c;

            // Try all combinations of incrementing the numbers a, b, and c up to 5 times in total
            for (int x = 0; x <= 5; x++) {
                for (int y = 0; y <= 5 - x; y++) {
                    int z = 5 - x - y;  // Total increments should be 5

                    int newA = a + x;
                    int newB = b + y;
                    int newC = c + z;

                    int product = newA * newB * newC;
                    if (product > maxProduct) {
                        maxProduct = product;
                    }
                }
            }

            System.out.println(maxProduct);
        }

        scanner.close();
    }
}
