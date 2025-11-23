import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Клас для представлення викладача у системі LMS.
 * Викладач реалізує інтерфейс Educational_schedule.
 */
public class Teacher extends Training_Participant implements Educational_schedule {
    private String scientific_degree;
    private String cathedra;
    private int experience;
    private List<Course> course_list;
    private List<Appeal> appeals;
    
    /**
     * Конструктор викладача.
     * @param name ім'я викладача
     * @param email електронна адреса викладача
     * @param scientific_degree науковий ступінь
     */
    public Teacher(String name, String email, String scientific_degree) {
        super(name, email);
        this.scientific_degree = scientific_degree;
        this.cathedra = "";
        this.experience = 0;
        this.course_list = new ArrayList<>();
        this.appeals = new ArrayList<>();
    }
    
    /**
     * Перевірити завдання студента.
     * @param exercise завдання для перевірки
     * @return оцінка за завдання
     */
    public double check_exercise(Exercise exercise) {
        System.out.println("  > Викладач " + name + " перевіряє завдання '" + exercise.getName() + "'");
        exercise.plagiarism_check();
        double grade = 80 + (Math.random() * 20); // Випадкова оцінка від 80 до 100
        System.out.println("  > Оцінка: " + String.format("%.2f", grade));
        return grade;
    }
    
    /**
     * Поставити оцінку студенту.
     * @param student студент
     * @param exercise завдання
     * @param grade оцінка
     */
    public void put_grade(Student student, Exercise exercise, double grade) {
        System.out.println("  > Викладач " + name + " ставить оцінку " + grade + 
                           " студенту " + student.getName() + " за завдання '" + exercise.getName() + "'");
        exercise.set_grade(grade);
        student.add_grade(exercise, grade);
    }
    
    /**
     * Створити завдання.
     * @param course курс
     * @param name назва завдання
     * @return нове завдання
     */
    public Exercise create_exercise(Course course, String name) {
        System.out.println("  > Викладач " + name + " створює завдання '" + name + "'");
        Exercise exercise = new Exercise(course.get_exercise_list().size() + 1, name, 
                                        "Завдання для курсу " + course.getName(),
                                        new Date(), 100);
        course.add_exercise(exercise);
        return exercise;
    }
    
    /**
     * Переглянути апеляції студентів.
     * @return список апеляцій
     */
    public List<Appeal> review_appeals() {
        System.out.println("  > Викладач " + name + " переглядає апеляції");
        if (appeals.isEmpty()) {
            System.out.println("    > Немає нових апеляцій");
        } else {
            System.out.println("    > Знайдено " + appeals.size() + " апеляцій");
        }
        return appeals;
    }
    
    /**
     * Додати апеляцію для розгляду.
     * @param appeal апеляція
     */
    public void add_appeal(Appeal appeal) {
        appeals.add(appeal);
        appeal.consider(this);
    }
    
    /**
     * Отримати профіль викладача.
     */
    @Override
    public String get_profile() {
        return "Teacher: " + name + ", Email: " + email + 
               ", Degree: " + scientific_degree + 
               ", Experience: " + experience + " years";
    }
    
    /**
     * Перевірити авторизацію викладача.
     */
    @Override
    public boolean authorization() {
        System.out.println("  > Авторизація викладача " + name);
        return true;
    }
    
    /**
     * Отримати розклад занять.
     */
    @Override
    public Map<Date, String> get_schedule() {
        System.out.println("  > Отримання розкладу для викладача " + name);
        Map<Date, String> schedule = new HashMap<>();
        for (Course c : course_list) {
            schedule.put(new Date(), "Teach: " + c.getName());
        }
        return schedule;
    }
    
    /**
     * Перевірити дедлайни.
     */
    @Override
    public List<Exercise> deadline_check() {
        System.out.println("  > Перевірка дедлайнів для викладача " + name);
        List<Exercise> upcoming = new ArrayList<>();
        for (Course c : course_list) {
            for (Exercise e : c.get_exercise_list()) {
                if ("submitted".equals(e.get_status())) {
                    upcoming.add(e);
                }
            }
        }
        System.out.println("    > Знайдено " + upcoming.size() + " завдань на перевірку");
        return upcoming;
    }
    
    /**
     * Показати навчальний план.
     */
    @Override
    public String show_curriculum() {
        System.out.println("  > Показ навчального плану для викладача " + name);
        StringBuilder plan = new StringBuilder("Curriculum taught by " + name + ":\n");
        for (Course c : course_list) {
            plan.append("- Course: ").append(c.getName()).append("\n");
        }
        return plan.toString();
    }
    
    /**
     * Додати курс до списку курсів викладача.
     * @param course курс
     */
    public void add_course(Course course) {
        course_list.add(course);
        System.out.println("  > Курс '" + course.getName() + "' додано до викладача " + name);
    }
    
    // Геттери та сеттери
    public String getScientific_degree() {
        return scientific_degree;
    }
    
    public String getCathedra() {
        return cathedra;
    }
    
    public void setCathedra(String cathedra) {
        this.cathedra = cathedra;
    }
    
    public int getExperience() {
        return experience;
    }
    
    public void setExperience(int experience) {
        this.experience = experience;
    }
    
    public List<Course> getCourse_list() {
        return course_list;
    }
}
