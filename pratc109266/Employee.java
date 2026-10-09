public class Employee {
    private String employeeId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String designation;
    private String department;
    private String skills;
    private String about;

    public Employee(String employeeId, String fullName, String email, String phoneNumber,
                    String designation, String department, String skills, String about) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.designation = designation;
        this.department = department;
        this.skills = skills;
        this.about = about;
    }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }

    public String getAbout() { return about; }
    public void setAbout(String about) { this.about = about; }

    private String cleanSpaces(String value) {
        if (value == null) return "";
        value = value.trim();
        StringBuilder sb = new StringBuilder();
        boolean previousSpace = false;

        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            if (Character.isWhitespace(ch)) {
                if (!previousSpace && sb.length() > 0) {
                    sb.append(' ');
                }
                previousSpace = true;
            } else {
                sb.append(ch);
                previousSpace = false;
            }
        }
        return sb.toString().trim();
    }

    private int countWords(String text) {
        if (text == null) return 0;
        text = cleanSpaces(text);
        if (text.isEmpty()) return 0;

        int count = 1;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isWhitespace(text.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public String getCleanFullName() {
        return cleanSpaces(fullName);
    }

    public String getNameUpperCase() {
        return getCleanFullName().toUpperCase();
    }

    public String getNameLowerCase() {
        return getCleanFullName().toLowerCase();
    }

    public int getNameLength() {
        return getCleanFullName().length();
    }

    public char getNameFirstChar() {
        String name = getCleanFullName();
        return name.isEmpty() ? '\0' : name.charAt(0);
    }

    public String getFirstName() {
        String name = getCleanFullName();
        int firstSpace = name.indexOf(' ');
        return firstSpace == -1 ? name : name.substring(0, firstSpace);
    }

    public String getLastName() {
        String name = getCleanFullName();
        int lastSpace = name.lastIndexOf(' ');
        return lastSpace == -1 ? name : name.substring(lastSpace + 1);
    }

    public String getMiddleName() {
        String name = getCleanFullName();
        int firstSpace = name.indexOf(' ');
        int lastSpace = name.lastIndexOf(' ');

        if (firstSpace == -1 || firstSpace == lastSpace) {
            return "";
        }
        return name.substring(firstSpace + 1, lastSpace).trim();
    }

    public int getNameWordCount() {
        return countWords(getCleanFullName());
    }

    public String getInitials() {
        String name = getCleanFullName();
        if (name.isEmpty()) return "";

        StringBuilder initials = new StringBuilder();
        boolean takeNext = true;

        int i=0;
        while (i < name.length()) {
            char ch = name.charAt(i);
            if (Character.isWhitespace(ch)) {
                takeNext = true;
            } else if (takeNext) {
                initials.append(Character.toUpperCase(ch));
                takeNext = false;
            }
            i++;
        }
        return initials.toString();
    }

    public String getCleanEmail() {
        return email == null ? "" : email.trim().toLowerCase();
    }

    public int getAtPosition() {
        return getCleanEmail().indexOf('@');
    }

    public String getEmailUsername() {
        int at = getAtPosition();
        return at >= 0 ? getCleanEmail().substring(0, at) : "";
    }

    public String getEmailDomain() {
        int at = getAtPosition();
        return at >= 0 ? getCleanEmail().substring(at + 1) : "";
    }

    public boolean emailContainsAt() {
        return getCleanEmail().indexOf('@') >= 0;
    }

    public boolean emailEndsWithCom() {
        return getCleanEmail().endsWith(".com");
    }

    public boolean emailBelongsToExampleCom() {
        return getEmailDomain().equalsIgnoreCase("example.com");
    }

    public boolean emailDomainEqualsIgnoreCase(String domain) {
        return getEmailDomain().equalsIgnoreCase(domain);
    }

    public String getCleanPhone() {
        StringBuilder digits = new StringBuilder();
        if (phoneNumber != null) {
            for (int i = 0; i < phoneNumber.length(); i++) {
                char ch = phoneNumber.charAt(i);
                if (Character.isDigit(ch)) {
                    digits.append(ch);
                }
            }
        }
        return digits.toString();
    }

    public int getPhoneLength() {
        return getCleanPhone().length();
    }

    public String getPhoneFirstThree() {
        String phone = getCleanPhone();
        return phone.length() >= 3 ? phone.substring(0, 3) : phone;
    }

    public String getPhoneLastFour() {
        String phone = getCleanPhone();
        return phone.length() >= 4 ? phone.substring(phone.length() - 4) : phone;
    }

    public boolean isPhoneValid() {
        return getPhoneLength() == 10;
    }

    public String getDesignationUpper() {
        return cleanSpaces(designation).toUpperCase();
    }

    public String getDesignationLower() {
        return cleanSpaces(designation).toLowerCase();
    }

    public boolean designationStartsWithSoftware() {
        return cleanSpaces(designation).startsWith("Software");
    }

    public boolean designationEndsWithEngineer() {
        return cleanSpaces(designation).endsWith("Engineer");
    }

    public boolean designationContainsEngineer() {
        return cleanSpaces(designation).contains("Engineer");
    }

    public String getDesignationWithDash() {
        return cleanSpaces(designation).replace(" ", "-");
    }

    public boolean knowsJava() {
        return skills != null && skills.contains("Java");
    }

    public boolean knowsReact() {
        return skills != null && skills.contains("React");
    }

    public boolean knowsPython() {
        return skills != null && skills.contains("Python");
    }

    public int getFirstCommaPosition() {
        return skills == null ? -1 : skills.indexOf(',');
    }

    public String getFirstSkill() {
        if (skills == null) return "";
        int firstComma = skills.indexOf(',');
        return (firstComma >= 0 ? skills.substring(0, firstComma) : skills).trim();
    }

    public String getLastSkill() {
        if (skills == null) return "";
        int lastComma = skills.lastIndexOf(',');
        return (lastComma >= 0 ? skills.substring(lastComma + 1) : skills).trim();
    }

    public int getSkillCount() {
        if (skills == null || skills.trim().isEmpty()) return 0;

        int count = 1;
        for (int i = 0; i < skills.length(); i++) {
            if (skills.charAt(i) == ',') {
                count++;
            }
        }
        return count;
    }

    public String getSkillsWithPipes() {
        return skills == null ? "" : skills.replace(",", " |").trim();
    }

    public int getAboutLength() {
        return about == null ? 0 : about.trim().length();
    }

    public int getAboutWordCount() {
        return countWords(about == null ? "" : about.trim());
    }

    public boolean aboutContainsJava() {
        return about != null && about.contains("Java");
    }

    public boolean aboutContainsPython() {
        return about != null && about.contains("Python");
    }

    public String getAboutWithFullStackJava() {
        return about == null ? "" : about.replace("Java", "Full Stack Java");
    }

    public String getAboutUpperCase() {
        return about == null ? "" : about.toUpperCase();
    }

    public String getAboutSummary() {
        String text = about == null ? "" : about.trim();
        return text.substring(0, Math.min(30, text.length()));
    }

    public boolean idStartsWithEMP() {
        return employeeId != null && employeeId.startsWith("EMP");
    }

    public String getEmpPrefix() {
        return idStartsWithEMP() ? employeeId.substring(0, 3) : "";
    }

    public String getNumericPart() {
        if (employeeId == null) return "";
        if (idStartsWithEMP()) return employeeId.substring(3);

        StringBuilder digits = new StringBuilder();
        for (int i = 0; i < employeeId.length(); i++) {
            if (Character.isDigit(employeeId.charAt(i))) {
                digits.append(employeeId.charAt(i));
            }
        }
        return digits.toString();
    }

    public int getIdLength() {
        return employeeId == null ? 0 : employeeId.length();
    }

    public String getNewEmployeeCode() {
        if (employeeId == null || employeeId.length() < 4) {
            return employeeId == null ? "" : employeeId;
        }

        String firstThree = employeeId.substring(0, Math.min(3, employeeId.length()));
        String lastFour = employeeId.substring(employeeId.length() - 4);
        return firstThree + lastFour;
    }

    public String getEmployeeType() {
        return "Employee";
    }

    public void displayProfile() {
        System.out.println("========== EMPLOYEE PROFILE ==========");
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Name : " + getCleanFullName());
        System.out.println("Initials : " + getInitials());
        System.out.println("Email : " + getCleanEmail());
        System.out.println("Email Username : " + getEmailUsername());
        System.out.println("Email Domain : " + getEmailDomain());
        System.out.println("Phone : " + getCleanPhone());
        System.out.println("Designation : " + cleanSpaces(designation));
        System.out.println("Department : " + (department == null ? "" : department.toUpperCase()));
        System.out.println("Skills:");
        System.out.println(getSkillsWithPipes());
        System.out.println("About:");
        System.out.println(about == null ? "" : about.trim());
    }
    public static void main(String[] args) {
        Employee emp = new Employee("EMP20261025"
," Rahul Kumar Sharma "
,"Rahul.Sharma@Example.COM"
,"98765-43210"
,"Software Engineer"
,"Java Development"
,"Java, Spring Boot, SQL, React, Docker"
,"Java developer with experience in building scalable web applications");
        emp.displayProfile();
    }
}