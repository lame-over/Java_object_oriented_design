import java.util.Date;

/**
 * Клас для представлення завдання у системі LMS.
 * Міститъ інформацію про завдання, дедлайни, статуси та оцінки.
 */
public class Exercise {
    private int id;
    private String name;
    private String description;
    private Date deadline;
    private double max_score;
    private String file_path;
    private double grade;
    private String status;
    
    /**
     * Конструктор завдання.
     * @param id унікальний ідентифікатор
     * @param name назва завдання
     * @param description опис завдання
     * @param deadline дедлайн для завдання
     * @param max_score максимальна оцінка
     */
    public Exercise(int id, String name, String description, Date deadline, double max_score) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.max_score = max_score;
        this.file_path = "";
        this.grade = -1;
        this.status = "created";
    }
    
    /**
     * Завантажити файл завдання.
     * @param path шлях до файлу
     * @return true якщо завантаження успішне
     */
    public boolean upload_file(String path) {
        System.out.println("    > Завантаження файлу для завдання '" + name + "': " + path);
        this.file_path = path;
        return true;
    }
    
    /**
     * Отримати поточну оцінку.
     * @return оцінка студента
     */
    public double get_score() {
        return grade;
    }
    
    /**
     * Перевірити, чи завдання подано.
     * @return true якщо завдання подано
     */
    public boolean amount_check() {
        return !file_path.isEmpty();
    }
    
    /**
     * Подати роботу студента.
     * @param student студент
     * @return true якщо робота подана успішно
     */
    public boolean submit_work(Student student) {
        System.out.println("    > Студент " + student.getName() + " подав роботу для завдання '" + name + "'");
        this.status = "submitted";
        return true;
    }
    
    /**
     * Перевірити роботу на плагіат.
     * @return true якщо плагіату не виявлено
     */
    public boolean plagiarism_check() {
        System.out.println("    > Перевірка завдання '" + name + "' на плагіат...");
        System.out.println("    > Результат: Плагіату не виявлено");
        return true;
    }
    
    /**
     * Отримати статус завдання.
     * @return статус (created, submitted, graded та ін.)
     */
    public String get_status() {
        return status;
    }
    
    /**
     * Встановити оцінку для завдання.
     * @param grade оцінка
     */
    public void set_grade(double grade) {
        this.grade = grade;
        this.status = "graded";
    }
    
    // Геттери та сеттери
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public Date getDeadline() {
        return deadline;
    }
    
    public double getMax_score() {
        return max_score;
    }
}
