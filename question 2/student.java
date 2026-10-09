public class student {
    private final String name;
    private final submarks[] marks;

    public student(String name, submarks[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public void display() {
        System.out.println("   Student Name: " + name);
        if (marks == null || marks.length == 0) {
            System.out.println("   No subject marks recorded.");
            return;
        }

        System.out.println("   Subjects:");
        for (submarks subject : marks) {
            subject.display();
        }
    }
}
