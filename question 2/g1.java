public class g1 {
	private final String groupName;
	private final String department;
	private final String mentor;
	private final student[] students;

	public g1(student[] students) {
		this("G1", "CSE", "Dr. Sharma", students);
	}

	protected g1(String groupName, String department, String mentor, student[] students) {
		this.groupName = groupName;
		this.department = department;
		this.mentor = mentor;
		this.students = students;
	}

	public void display() {
	System.out.println();
		System.out.println("Group: " + groupName + " | Department: " + department);
		System.out.println("Mentor: " + mentor);
		System.out.println();
		if (students == null || students.length == 0) {
			System.out.println("No students enrolled in this group.");
		} else {
			for (int i = 0; i < students.length; i++) {
				System.out.println("[" + (i + 1) + "]");
				students[i].display();
			}
		}
		System.out.println("\n");
	}
}
