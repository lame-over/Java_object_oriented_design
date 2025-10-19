/**
 * Клас, що представляє студента в системі
 */
public class Student extends EducationParticipant {
    private boolean isPaid;
    private double grade;

    public Student(String name, String email) {
        super(name, email, "Студент");
        this.isPaid = false;
        this.grade = 0.0;
    }

    public void payForCourse() {
        System.out.println("Студент " + name + " оплачує курс");
        this.isPaid = true;
    }

    public void submitWork() {
        System.out.println("Студент " + name + " подає роботу");
    }

    public void submitAppeal() {
        System.out.println("Студент " + name + " подає апеляцію");
    }

    public void viewGrade() {
        System.out.println("Оцінка студента " + name + ": " + grade);
    }

    // Метод для встановлення оцінки (використовується викладачем)
    public void setGrade(double grade) {
        this.grade = grade;
    }
}