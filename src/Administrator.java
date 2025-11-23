import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Клас для представлення адміністратора у системі LMS.
 * Адміністратор реалізує інтерфейс Educational_schedule.
 */
public class Administrator extends Training_Participant implements Educational_schedule {
    private String department;
    private int access_level;
    private String phone;
    private List<Course> managed_courses;
    
    /**
     * Конструктор адміністратора.
     * @param name ім'я адміністратора
     * @param email електронна адреса адміністратора
     * @param department відділ/кафедра
     */
    public Administrator(String name, String email, String department) {
        super(name, email);
        this.department = department;
        this.access_level = 3; // Високий рівень доступу
        this.phone = "";
        this.managed_courses = new ArrayList<>();
    }
    
    /**
     * Налаштувати дедлайн для завдання.
     * @param exercise завдання
     * @param deadline дедлайн
     */
    public void set_deadline(Exercise exercise, Date deadline) {
        System.out.println("  > Адміністратор " + name + " встановлює дедлайн для завдання '" + 
                           exercise.getName() + "' на " + deadline);
    }
    
    /**
     * Керувати доступом користувача до курсу.
     * @param user користувач
     * @param course курс
     * @return true якщо доступ надано
     */
    public boolean manage_access(Training_Participant user, Course course) {
        System.out.println("  > Адміністратор " + name + " налаштовує доступ для користувача " + 
                           user.getName() + " до курсу '" + course.getName() + "'");
        return true;
    }
    
    /**
     * Створити новий курс.
     * @param code код курсу
     * @param name назва курсу
     * @param description опис курсу
     * @param credits кількість кредитів
     * @param price ціна
     * @return новий курс
     */
    public Course create_course(String code, String name, String description, int credits, double price) {
        System.out.println("  > Адміністратор " + name + " створює новий курс '" + name + "'");
        Course course = new Course(code, name, description, credits, price);
        managed_courses.add(course);
        return course;
    }
    
    /**
     * Переглянути статистику системи.
     * @return рядок зі статистикою
     */
    public String view_statistic() {
        System.out.println("  > Адміністратор " + name + " переглядає статистику системи");
        StringBuilder stats = new StringBuilder("System Statistics:\n");
        stats.append("- Total Courses: ").append(managed_courses.size()).append("\n");
        int total_students = 0;
        for (Course c : managed_courses) {
            total_students += c.get_student_list().size();
        }
        stats.append("- Total Students: ").append(total_students).append("\n");
        return stats.toString();
    }
    
    /**
     * Отримати профіль адміністратора.
     */
    @Override
    public String get_profile() {
        return "Administrator: " + name + ", Email: " + email + 
               ", Department: " + department + 
               ", Access Level: " + access_level;
    }
    
    /**
     * Перевірити авторизацію адміністратора.
     */
    @Override
    public boolean authorization() {
        System.out.println("  > Авторизація адміністратора " + name);
        return true;
    }
    
    /**
     * Отримати розклад.
     */
    @Override
    public Map<Date, String> get_schedule() {
        System.out.println("  > Отримання адміністративного розкладу для " + name);
        Map<Date, String> schedule = new HashMap<>();
        schedule.put(new Date(), "Administrative Tasks");
        return schedule;
    }
    
    /**
     * Перевірити дедлайни.
     */
    @Override
    public List<Exercise> deadline_check() {
        System.out.println("  > Перевірка всіх дедлайнів у системі");
        List<Exercise> all_exercises = new ArrayList<>();
        for (Course c : managed_courses) {
            all_exercises.addAll(c.get_exercise_list());
        }
        System.out.println("    > Всього завдань в системі: " + all_exercises.size());
        return all_exercises;
    }
    
    /**
     * Показати навчальний план.
     */
    @Override
    public String show_curriculum() {
        System.out.println("  > Показ всіх курсів у системі");
        StringBuilder plan = new StringBuilder("All Courses in the System:\n");
        for (Course c : managed_courses) {
            plan.append("- ").append(c.getName()).append(" (").append(c.getCode()).append(")\n");
        }
        return plan.toString();
    }
    
    // Геттери та сеттери
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public int getAccess_level() {
        return access_level;
    }
    
    public void setAccess_level(int access_level) {
        this.access_level = access_level;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public List<Course> getManaged_courses() {
        return managed_courses;
    }
}
