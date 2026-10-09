public class submarks {
    private final String subjectId;
    private final String subjectName;
    private final double marks;

    public submarks(String subjectId, String subjectName, double marks) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.marks = marks;
    }

    public void display() {
        System.out.println("      - [" + subjectId + "] " + subjectName + ": " + marks);
    }
}
