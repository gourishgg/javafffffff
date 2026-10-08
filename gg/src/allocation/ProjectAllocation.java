package allocation;

import java.util.Arrays;

public class ProjectAllocation {
    private int[][] hours;
    private int numEmployees;
    private int numProjects;

    public ProjectAllocation(int[][] initialHours) {
        if (initialHours == null || initialHours.length == 0
                || initialHours[0] == null || initialHours[0].length == 0) {
            throw new IllegalArgumentException("Working hours matrix cannot be null or empty.");
        }

        this.numEmployees = initialHours.length;
        this.numProjects = initialHours[0].length;
        this.hours = new int[numEmployees][numProjects];

        for (int i = 0; i < numEmployees; i++) {
            if (initialHours[i] == null || initialHours[i].length != numProjects) {
                throw new IllegalArgumentException("Working hours matrix must be rectangular.");
            }
            this.hours[i] = Arrays.copyOf(initialHours[i], numProjects);
        }
    }

    public void displayEmployeeReport() {
        System.out.println("");
        System.out.println("           EMPLOYEE-WISE ALLOCATION REPORT        ");
        System.out.println("");

        System.out.printf("%-15s", "");
        for (int j = 0; j < numProjects; j++) {
            System.out.printf("%-10s", "P" + (j + 1));
        }
        System.out.println();

        for (int i = 0; i < numEmployees; i++) {
            System.out.printf("%-15s", "Employee E" + (i + 1));
            for (int j = 0; j < numProjects; j++) {
                System.out.printf("%-10d", hours[i][j]);
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public int[] calculateEmployeeTotal() {
        int[] employeeTotals = new int[numEmployees];

        System.out.println("");
        System.out.println("              EMPLOYEE TOTAL HOURS                ");
        System.out.println("");

        for (int i = 0; i < numEmployees; i++) {
            int total = 0;
            for (int j = 0; j < numProjects; j++) {
                total += hours[i][j];
            }
            employeeTotals[i] = total;
            System.out.println("- Employee E" + (i + 1) + " Total: " + total + " hours");
        }
        System.out.println("\n");

        return employeeTotals;
    }

    public int[][] generateProjectReport() {
        int[][] transpose = new int[numProjects][numEmployees];

        for (int i = 0; i < numEmployees; i++) {
            for (int j = 0; j < numProjects; j++) {
                transpose[j][i] = hours[i][j];
            }
        }
        System.out.println("TRANSPOSE MATRIX");

        System.out.printf("%-15s", "");
        for (int i = 0; i < numEmployees; i++) {
            System.out.printf("%-10s", "E" + (i + 1));
        }
        System.out.println();
        for (int j = 0; j < numProjects; j++) {
            System.out.printf("%-15s", "Project P" + (j + 1));
            for (int i = 0; i < numEmployees; i++) {
                System.out.printf("%-10d", transpose[j][i]);
            }
            System.out.println();
        }

        return transpose;
    }

    public int[] calculateProjectTotal() {
        int[] projectTotals = new int[numProjects];

        System.out.println("");
        System.out.println("               PROJECT TOTAL HOURS                ");
        System.out.println("");

        for (int j = 0; j < numProjects; j++) {
            int total = 0;
            for (int i = 0; i < numEmployees; i++) {
                total += hours[i][j];
            }
            projectTotals[j] = total;
            System.out.println("- Project P" + (j + 1) + " Total: " + total + " hours");
        }
        System.out.println("\n");

        return projectTotals;
    }

    public String findMostWorkedProject() {
        int[] projectTotals = new int[numProjects];

        for (int j = 0; j < numProjects; j++) {
            int total = 0;
            for (int i = 0; i < numEmployees; i++) {
                total += hours[i][j];
            }
            projectTotals[j] = total;
        }

        int maxHours = projectTotals[0];
        int maxProjectIndex = 0;

        for (int j = 1; j < numProjects; j++) {
            if (projectTotals[j] > maxHours) {
                maxHours = projectTotals[j];
                maxProjectIndex = j;
            }
        }

        String mostWorkedProject = "P" + (maxProjectIndex + 1);

        System.out.println();
        System.out.println("               MOST WORKED PROJECT                ");
        System.out.println();
        System.out.println("- Most Worked Project: " + mostWorkedProject);
        System.out.println("\n");

        return mostWorkedProject;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public int getNumProjects() {
        return numProjects;
    }

    public int[][] getHours() {
        int[][] copy = new int[numEmployees][numProjects];
        for (int i = 0; i < numEmployees; i++) {
            copy[i] = Arrays.copyOf(this.hours[i], numProjects);
        }
        return copy;
    }
}
