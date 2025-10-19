/**
 * Базовий клас для всіх учасників навчального процесу
 */
public abstract class EducationParticipant implements ISchedule {
    protected String name;
    protected String email;
    protected String role;

    public EducationParticipant(String name, String email, String role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    // Геттери та сеттери
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    // Реалізація методів інтерфейсу
    @Override
    public void viewSchedule() {
        System.out.println("[" + role + "] " + name + " переглядає розклад");
    }

    @Override
    public void updateSchedule() {
        System.out.println("[" + role + "] " + name + " оновлює розклад");
    }
}