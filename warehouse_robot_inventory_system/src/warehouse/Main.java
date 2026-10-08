package warehouse;

/**
 * Main application class to demonstrate the Warehouse Robot Inventory System.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("**************************************************");
        System.out.println("       WAREHOUSE ROBOT INVENTORY SYSTEM DEMO      ");
        System.out.println("**************************************************\n");

        // Example Input from Problem Statement (4x4 Grid)
        int[][] exampleGrid = {
            { 10,  20,  30,  40},
            { 50,  60,  70,  80},
            { 90, 100, 110, 120},
            {130, 140, 150, 160}
        };

        // 1. Create an object of Warehouse in main() using the constructor
        Warehouse warehouse = new Warehouse(exampleGrid);

        // 2. Display the warehouse layout
        warehouse.displayInventory();

        // 3. Print the robot visit order in spiral traversal
        warehouse.getRobotVisitOrder();

        // 4. Calculate total boundary stock
        warehouse.calculateBoundaryStock();

        // 5. Identify the section with maximum stock
        warehouse.findMaximumSection();

        System.out.println("**************************************************");
        System.out.println("           DEMONSTRATION COMPLETED                ");
        System.out.println("**************************************************");
    }
}
