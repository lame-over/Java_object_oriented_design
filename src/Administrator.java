/**
 * Клас, що представляє адміністратора в системі
 */
public class Administrator extends EducationParticipant {
    public Administrator(String name, String email) {
        super(name, email, "Адміністратор");
    }

    public void configureDeadlines() {
        System.out.println("Адміністратор " + name + " налаштовує дедлайни");
    }

    public void configureAccess() {
        System.out.println("Адміністратор " + name + " налаштовує права доступу");
    }

    public void configureCourse() {
        System.out.println("Адміністратор " + name + " налаштовує параметри курсу");
    }
}