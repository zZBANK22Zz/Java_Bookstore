package Homework.Lab5;

class Subject {
    private String subjectId;
    private String name;
    private int credit;

    public Subject(String subjectId, String name, int credit) {
        this.subjectId = subjectId;
        this.name = name;
        this.credit = credit;
    }

    //Ananthichai Saehui 6530613030 DE.

    public void printSubject() {
        System.out.println("Subject ID: " + subjectId + " " + name + " " + credit + " credits.");
    }

    public String getSubjectId() {
        return subjectId;
    }
}
