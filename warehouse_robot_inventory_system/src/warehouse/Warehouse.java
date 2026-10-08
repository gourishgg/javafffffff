package warehouse;

import java.util.Arrays;

/**
 * Warehouse class manages product inventory in an N x N grid.
 * Demonstrates Java OOP principles, 2D array traversals, boundary calculations,
 * and spiral robot path traversal.
 */
public class Warehouse {
    // Encapsulated 2D array to store inventory stock
    private int[][] inventory;
    private int size; // N for N x N grid

    /**
     * Constructor to initialize the warehouse inventory.
     * Performs a defensive copy to maintain encapsulation.
     *
     * @param initialInventory 2D integer array representing the warehouse layout.
     */
    public Warehouse(int[][] initialInventory) {
        if (initialInventory == null || initialInventory.length == 0) {
            throw new IllegalArgumentException("Inventory matrix cannot be null or empty.");
        }

        this.size = initialInventory.length;

        // Ensure square matrix N x N
        for (int i = 0; i < size; i++) {
            if (initialInventory[i].length != size) {
                throw new IllegalArgumentException("Warehouse inventory must be a square (N x N) matrix.");
            }
        }

        this.inventory = new int[size][size];

        // Manual deep copy using nested loops
        for (int i = 0; i < size; i++) {
            this.inventory[i] = Arrays.copyOf(initialInventory[i], size);
        }
    }

    /**
     * Displays the 2D warehouse inventory grid layout.
     */
    public void displayInventory() {
        System.out.println("==================================================");
        System.out.println("            WAREHOUSE INVENTORY LAYOUT            ");
        System.out.println("==================================================");

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%6d", inventory[i][j]);
            }
            System.out.println();
        }
        System.out.println("==================================================\n");
    }

    /**
     * Traverses the inventory grid in spiral order (boundary first, then moving inward)
     * simulating the robot visit order, prints the order, and returns the visited sequence.
     *
     * @return 1D array of inventory values visited in spiral order.
     */
    public int[] getRobotVisitOrder() {
        int[] visitOrder = new int[size * size];
        int index = 0;

        int top = 0;
        int bottom = size - 1;
        int left = 0;
        int right = size - 1;

        while (top <= bottom && left <= right) {
            // 1. Traverse left to right across the top row
            for (int j = left; j <= right; j++) {
                visitOrder[index++] = inventory[top][j];
            }
            top++;

            // 2. Traverse top to bottom down the rightmost column
            for (int i = top; i <= bottom; i++) {
                visitOrder[index++] = inventory[i][right];
            }
            right--;

            // 3. Traverse right to left across the bottom row (if rows remain)
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    visitOrder[index++] = inventory[bottom][j];
                }
                bottom--;
            }

            // 4. Traverse bottom to top up the leftmost column (if columns remain)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    visitOrder[index++] = inventory[i][left];
                }
                left++;
            }
        }

        // Display robot visit order
        System.out.println("==================================================");
        System.out.println("             ROBOT VISIT ORDER (SPIRAL)           ");
        System.out.println("==================================================");

        for (int i = 0; i < visitOrder.length; i++) {
            System.out.print(visitOrder[i] + " ");
            // Line break every 8 elements for clean presentation matching example
            if ((i + 1) % 8 == 0 || i == visitOrder.length - 1) {
                System.out.println();
            }
        }
        System.out.println("==================================================\n");

        return visitOrder;
    }

    /**
     * Calculates and displays the total products stored in all boundary sections.
     * Boundary sections are cells in row 0, row N-1, col 0, or col N-1.
     *
     * @return Total boundary stock.
     */
    public int calculateBoundaryStock() {
        int totalBoundaryStock = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Check if the section lies on the outer boundary
                if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
                    totalBoundaryStock += inventory[i][j];
                }
            }
        }

        System.out.println("==================================================");
        System.out.println("               BOUNDARY STOCK SUMMARY             ");
        System.out.println("==================================================");
        System.out.println("Total Boundary Stock: " + totalBoundaryStock + " products");
        System.out.println("==================================================\n");

        return totalBoundaryStock;
    }

    /**
     * Identifies and displays the section containing the maximum number of products.
     *
     * @return The maximum stock value found.
     */
    public int findMaximumSection() {
        int maxStock = inventory[0][0];
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (inventory[i][j] > maxStock) {
                    maxStock = inventory[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.println("==================================================");
        System.out.println("              MAXIMUM SECTION STOCK               ");
        System.out.println("==================================================");
        System.out.println("Maximum Stock: " + maxStock + " products");
        System.out.println("Location: Section at Row " + maxRow + ", Column " + maxCol + " (1-based: Section [" + (maxRow + 1) + ", " + (maxCol + 1) + "])");
        System.out.println("==================================================\n");

        return maxStock;
    }

    // Encapsulation getters
    public int getSize() {
        return size;
    }

    public int[][] getInventory() {
        int[][] copy = new int[size][size];
        for (int i = 0; i < size; i++) {
            copy[i] = Arrays.copyOf(inventory[i], size);
        }
        return copy;
    }
}
