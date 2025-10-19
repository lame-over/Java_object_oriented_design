/**
 * Клас, що представляє викладача в системі
 */
public class Teacher extends EducationParticipant {
    public Teacher(String name, String email) {
        super(name, email, "Викладач");
    }

    public void checkWork(Student student, double grade) {
        System.out.println("Викладач " + name + " перевіряє роботу студента " + student.getName());
        System.out.println("Робота відправляється на перевірку плагіату...");
        System.out.println("Виставляється оцінка: " + grade);
        student.setGrade(grade);
    }

    public void reviewAppeal() {
        System.out.println("Викладач " + name + " розглядає апеляцію");
    }

    public void createAssignment() {
        System.out.println("Викладач " + name + " створює нове завдання");
    }
}