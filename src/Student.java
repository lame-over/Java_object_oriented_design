import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Клас для представлення студента у системі LMS.
 * Студент реалізує інтерфейс Educational_schedule.
 */
public class Student extends Training_Participant implements Educational_schedule {
    private String student_id;
    private int course;
    private boolean payment_status;
    private double average_score;
    private List<Course> enrolled_courses;
    private Map<Exercise, Double> grades;
    
    /**
     * Конструктор студента.
     * @param name ім'я студента
     * @param email електронна адреса студента
     * @param student_id унікальний ідентифікатор студента
     */
    public Student(String name, String email, String student_id) {
        super(name, email);
        this.student_id = student_id;
        this.course = 1;
        this.payment_status = false;
        this.average_score = 0;
        this.enrolled_courses = new ArrayList<>();
        this.grades = new HashMap<>();
    }
    
    /**
     * Оплатити курс.
     * @param course курс для оплати
     * @return true якщо оплата успішна
     */
    public boolean pay_course(Course course) {
        System.out.println("  > Студент " + name + " оплачує курс '" + course.getName() + "'");
        this.payment_status = true;
        this.enrolled_courses.add(course);
        course.add_student(this);
        System.out.println("  > Оплата завершена. Студент зареєстрований на курсі.");
        return true;
    }
    
    /**
     * Подати апеляцію на оцінку.
     * @param exercise завдання
     * @param reason причина апеляції
     * @return новий об'єкт Appeal
     */
    public Appeal file_an_appeal(Exercise exercise, String reason) {
        System.out.println("  > Студент " + name + " подає апеляцію на завдання '" + exercise.getName() + "'");
        return new Appeal(this, exercise, reason);
    }
    
    /**
     * Показати оцінки студента.
     * @return Map з завданнями та оцінками
     */
    public Map<Exercise, Double> show_grades() {
        System.out.println("  > Показуються оцінки студента " + name + ":");
        for (Map.Entry<Exercise, Double> entry : grades.entrySet()) {
            System.out.println("    - " + entry.getKey().getName() + ": " + entry.getValue());
        }
        return grades;
    }
    
    /**
     * Отримати академічний сертифікат (фінальний метод).
     * @return сертифікат
     */
    public final String get_academic_certificate() {
        System.out.println("  > Генерація академічного сертифіката для " + name);
        return "Certificate for " + name + " (ID: " + student_id + 
               ") - Average Score: " + average_score;
    }
    
    /**
     * Отримати профіль студента.
     */
    @Override
    public String get_profile() {
        return "Student: " + name + ", Email: " + email + 
               ", ID: " + student_id + ", Payment: " + 
               (payment_status ? "Paid" : "Not Paid");
    }
    
    /**
     * Перевірити авторизацію студента.
     */
    @Override
    public boolean authorization() {
        System.out.println("  > Авторизація студента " + name);
        return true;
    }
    
    /**
     * Отримати розклад занять.
     */
    @Override
    public Map<Date, String> get_schedule() {
        System.out.println("  > Отримання розкладу для студента " + name);
        Map<Date, String> schedule = new HashMap<>();
        for (Course c : enrolled_courses) {
            schedule.put(new Date(), "Course: " + c.getName());
        }
        return schedule;
    }
    
    /**
     * Перевірити дедлайни.
     */
    @Override
    public List<Exercise> deadline_check() {
        System.out.println("  > Перевірка дедлайнів для студента " + name);
        List<Exercise> upcoming = new ArrayList<>();
        for (Course c : enrolled_courses) {
            for (Exercise e : c.get_exercise_list()) {
                if ("created".equals(e.get_status()) || "submitted".equals(e.get_status())) {
                    upcoming.add(e);
                }
            }
        }
        System.out.println("    > Знайдено " + upcoming.size() + " невиконаних завдань");
        return upcoming;
    }
    
    /**
     * Показати навчальний план.
     */
    @Override
    public String show_curriculum() {
        System.out.println("  > Показ навчального плану для студента " + name);
        StringBuilder plan = new StringBuilder("Curriculum for " + name + ":\n");
        for (Course c : enrolled_courses) {
            plan.append("- Course: ").append(c.getName()).append(" (Credits: ").append(c.getCredits()).append(")\n");
        }
        return plan.toString();
    }
    
    /**
     * Подати роботу для завдання.
     * @param exercise завдання
     * @param file_path шлях до файлу роботи
     */
    public void submit_exercise(Exercise exercise, String file_path) {
        System.out.println("  > Студент " + name + " подає роботу для завдання '" + exercise.getName() + "'");
        exercise.upload_file(file_path);
        exercise.submit_work(this);
    }
    
    /**
     * Додати оцінку до профілю студента.
     * @param exercise завдання
     * @param grade оцінка
     */
    public void add_grade(Exercise exercise, double grade) {
        grades.put(exercise, grade);
        // Розраховуємо середню оцінку
        double sum = 0;
        for (double g : grades.values()) {
            sum += g;
        }
        average_score = sum / grades.size();
    }
    
    // Геттери та сеттери
    public String getStudent_id() {
        return student_id;
    }
    
    public boolean isPayment_status() {
        return payment_status;
    }
    
    public double getAverage_score() {
        return average_score;
    }
    
    public List<Course> getEnrolled_courses() {
        return enrolled_courses;
    }
}
