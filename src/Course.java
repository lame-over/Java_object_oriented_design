import java.util.ArrayList;
import java.util.List;

/**
 * Клас для представлення курсу у системі LMS.
 * Містить інформацію про курс, студентів та завдання.
 */
public class Course {
    private String code;
    private String name;
    private String description;
    private int credits;
    private double price;
    private List<Student> students;
    private List<Exercise> exercises;
    
    /**
     * Конструктор курсу.
     * @param code код курсу
     * @param name назва курсу
     * @param description опис курсу
     * @param credits кількість кредитів
     * @param price ціна курсу
     */
    public Course(String code, String name, String description, int credits, double price) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.credits = credits;
        this.price = price;
        this.students = new ArrayList<>();
        this.exercises = new ArrayList<>();
    }
    
    /**
     * Додати студента до курсу.
     * @param student студент для додавання
     * @return true якщо студент доданий успішно
     */
    public boolean add_student(Student student) {
        System.out.println("  > Додавання студента " + student.getName() + " до курсу " + name);
        return students.add(student);
    }
    
    /**
     * Додати завдання до курсу.
     * @param exercise завдання для додавання
     */
    public void add_exercise(Exercise exercise) {
        System.out.println("  > Додавання завдання '" + exercise.getName() + "' до курсу " + name);
        exercises.add(exercise);
    }
    
    /**
     * Отримати список студентів курсу.
     * @return список студентів
     */
    public List<Student> get_student_list() {
        return students;
    }
    
    /**
     * Отримати список завдань курсу.
     * @return список завдань
     */
    public List<Exercise> get_exercise_list() {
        return exercises;
    }
    
    // Геттери та сеттери
    public String getCode() {
        return code;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public int getCredits() {
        return credits;
    }
    
    public double getPrice() {
        return price;
    }
}
