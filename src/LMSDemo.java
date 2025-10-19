/**
 * Головний клас для демонстрації роботи системи
 */
public class LMSDemo {
    public static void main(String[] args) {
        // Створення учасників
        Student student = new Student("Іван Петренко", "ivan@student.com");
        Teacher teacher = new Teacher("Марія Іваненко", "maria@teacher.com");
        Administrator admin = new Administrator("Олександр Сидоренко", "admin@lms.com");

        // Демонстрація роботи адміністратора
        System.out.println("\n=== Налаштування системи ===");
        admin.configureCourse();
        admin.configureDeadlines();
        admin.configureAccess();

        // Демонстрація роботи студента
        System.out.println("\n=== Дії студента ===");
        student.payForCourse();
        student.viewSchedule();
        student.submitWork();

        // Демонстрація роботи викладача
        System.out.println("\n=== Дії викладача ===");
        teacher.createAssignment();
        teacher.checkWork(student, 85.5);

        // Перегляд оцінки студентом
        System.out.println("\n=== Перегляд результатів ===");
        student.viewGrade();

        // Демонстрація процесу апеляції
        System.out.println("\n=== Процес апеляції ===");
        student.submitAppeal();
        teacher.reviewAppeal();
    }
}