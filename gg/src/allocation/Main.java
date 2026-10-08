
package allocation;

public class Main {
    public static void main(String[] args) {
        System.out.println("");
        System.out.println("        EMPLOYEE-PROJECT ALLOCATION SYSTEM        ");
        System.out.println("\n");

        int[][] sampleHours = {
            {20, 15, 10}, 
            {12, 18, 14}, 
            {25, 10, 20}, 
            {15, 22, 12}  
        };

        ProjectAllocation system = new ProjectAllocation(sampleHours);

        system.displayEmployeeReport();

        system.calculateEmployeeTotal();

        system.generateProjectReport();

        system.calculateProjectTotal();

        system.findMostWorkedProject();

       
    }
}
