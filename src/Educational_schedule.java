import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Інтерфейс для роботи з освітнім розкладом.
 * Визначає контракт для керування розкладом навчання.
 */
public interface Educational_schedule {
    /**
     * Отримати розклад на основі дат та занять.
     * @return Map з датами та описами занять
     */
    Map<Date, String> get_schedule();
    
    /**
     * Перевірити дедлайни на предмет наближення.
     * @return Список завдань, яких дедлайни наближаються
     */
    List<Exercise> deadline_check();
    
    /**
     * Показати навчальний план.
     * @return Рядок з описом навчального плану
     */
    String show_curriculum();
}
