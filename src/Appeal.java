import java.util.Date;

/**
 * Клас для представлення апеляції студента у системі LMS.
 * Студент може подати апеляцію на оцінку.
 */
public class Appeal {
    private int id;
    private Date submission_date;
    private String reason;
    private String status;
    private String decision;
    private Student student;
    private Exercise exercise;
    
    private static int counter = 0;
    
    /**
     * Конструктор апеляції.
     * @param student студент, що подає апеляцію
     * @param exercise завдання, на яке подається апеляція
     * @param reason причина апеляції
     */
    public Appeal(Student student, Exercise exercise, String reason) {
        this.id = ++counter;
        this.student = student;
        this.exercise = exercise;
        this.reason = reason;
        this.submission_date = new Date();
        this.status = "pending";
        this.decision = "";
    }
    
    /**
     * Розглянути апеляцію.
     * @param teacher викладач, що розглядає апеляцію
     */
    public void consider(Teacher teacher) {
        System.out.println("    > Викладач " + teacher.getName() + " розглядає апеляцію #" + id);
        System.out.println("    > Причина: " + reason);
    }
    
    /**
     * Оновити статус апеляції.
     * @param new_status новий статус
     */
    public void update_status(String new_status) {
        this.status = new_status;
        System.out.println("    > Статус апеляції #" + id + " оновлено на: " + new_status);
    }
    
    /**
     * Встановити рішення по апеляції.
     * @param decision рішення (прийнято/відхилено)
     * @param new_grade нова оцінка (якщо апеляція прийнята)
     */
    public void set_decision(String decision, double new_grade) {
        this.decision = decision;
        if ("accepted".equals(decision)) {
            this.status = "accepted";
            exercise.set_grade(new_grade);
            System.out.println("    > Апеляція #" + id + " прийнята. Нова оцінка: " + new_grade);
        } else {
            this.status = "rejected";
            System.out.println("    > Апеляція #" + id + " відхилена");
        }
    }
    
    /**
     * Отримати інформацію про апеляцію.
     * @return рядок з інформацією про апеляцію
     */
    public String get_info() {
        return "Appeal #" + id + " - Student: " + student.getName() + 
               ", Exercise: " + exercise.getName() + 
               ", Status: " + status + 
               ", Decision: " + decision;
    }
    
    // Геттери та сеттери
    public int getId() {
        return id;
    }
    
    public String getReason() {
        return reason;
    }
    
    public String getStatus() {
        return status;
    }
    
    public String getDecision() {
        return decision;
    }
}
