import java.util.Date;

/**
 * Абстрактний клас для представлення учасника навчального процесу.
 * Інкапсулює спільну поведінку всіх учасників.
 */
public abstract class Training_Participant {
    protected String name;
    protected String email;
    protected Date registration_date;
    
    /**
     * Конструктор абстрактного учасника.
     * @param name ім'я учасника
     * @param email електронна адреса
     */
    public Training_Participant(String name, String email) {
        this.name = name;
        this.email = email;
        this.registration_date = new Date();
    }
    
    /**
     * Отримати профіль учасника.
     * @return рядок з інформацією про профіль
     */
    public abstract String get_profile();
    
    /**
     * Перевірити авторизацію.
     * @return true якщо авторизація успішна, false інакше
     */
    public abstract boolean authorization();
    
    // Геттери та сеттери
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Date getRegistration_date() {
        return registration_date;
    }
}
