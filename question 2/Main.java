public class Main {
    public static void main(String[] args) {
        submarks dataStructures = new submarks("CS101", "Data Structures", 85.5);
        submarks networks = new submarks("CS102", "Computer Networks", 92.0);
        submarks operatingSystems = new submarks("CS103", "Operating Systems", 78.0);

        student alice = new student("Alice", new submarks[]{dataStructures});
        student bob = new student("Bob", new submarks[]{dataStructures, networks});
        student charlie = new student("Charlie", new submarks[]{networks, operatingSystems});
        student david = new student("David", new submarks[]{dataStructures, operatingSystems});

        g1 group1 = new g1(new student[]{alice, bob, charlie});
        g2 group2 = new g2(new student[]{david});

        group1.display();
        group2.display();
    }
}