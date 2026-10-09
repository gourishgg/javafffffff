import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students in batch 1: ");
        int n = scanner.nextInt();
        System.out.print("Enter the number of subjects in batch 1: ");
        int m = scanner.nextInt();

        System.out.print("Enter the number of students in batch 2: ");
        int n2 = scanner.nextInt();
        System.out.print("Enter the number of subjects in batch 2: ");
        int m2 = scanner.nextInt();

        int[][] marksb1 = new int[n][m];
        
        int[][] marksb2 = new int[n2][m2];
for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for student " + (i + 1) + " in batch 1:");
            for (int j = 0; j < m; j++) {
                marksb1[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < n2; i++) {
            System.out.println("Enter marks for student " + (i + 1) + " in batch 2:");
            for (int j = 0; j < m2; j++) {
                marksb2[i][j] = scanner.nextInt();
            }
        }
        cons c1 = new cons(marksb1);
        c1.displaymarks();
        c1.calculatetotal(0);
        c1.findToper();

        cons c2 = new cons(marksb2);
        c2.displaymarks();
        c2.calculatetotal(0);
        c2.findToper();
    }
}