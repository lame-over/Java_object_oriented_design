import java.util.Date;

/**
 * Клас Main для запуску симуляції системи LMS.
 * Демонструє базову функціональність системи управління навчанням.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   LMS - Система управління навчанням");
        System.out.println("========================================\n");
        
        // Крок 1: Адміністратор налаштовує систему
        System.out.println("=== КРОК 1: Налаштування системи адміністратором ===\n");
        Administrator admin = new Administrator("Іван Петренко", "admin@lms.ua", "IT Department");
        admin.setPhone("+380501234567");
        System.out.println(admin.get_profile());
        System.out.println();
        
        // Адміністратор створює курси
        System.out.println("--- Створення курсів ---");
        Course java_course = admin.create_course("JAVA-101", "Основи Java", 
                                                 "Введення у мову програмування Java", 4, 150.0);
        Course db_course = admin.create_course("DB-101", "Бази даних", 
                                               "Основи реляційних баз даних", 3, 100.0);
        System.out.println();
        
        // Крок 2: Викладачі готують матеріали
        System.out.println("=== КРОК 2: Викладачі готують матеріали ===\n");
        Teacher teacher1 = new Teacher("Марія Коваленко", "teacher1@lms.ua", "Ph.D.");
        teacher1.setExperience(8);
        System.out.println(teacher1.get_profile());
        System.out.println();
        
        System.out.println("--- Викладач збирає курси ---");
        teacher1.add_course(java_course);
        System.out.println();
        
        System.out.println("--- Створення завдань ---");
        Exercise exercise1 = teacher1.create_exercise(java_course, "Хелло Світ");
        Exercise exercise2 = teacher1.create_exercise(java_course, "Цикли та масиви");
        System.out.println();
        
        // Крок 3: Студенти реєструються і оплачують курси
        System.out.println("=== КРОК 3: Студенти реєструються та оплачують курси ===\n");
        Student student1 = new Student("Олег Сидоренко", "student1@lms.ua", "S001");
        System.out.println(student1.get_profile());
        System.out.println();
        
        System.out.println("--- Оплата курсу ---");
        student1.pay_course(java_course);
        System.out.println();
        
        Student student2 = new Student("Ганна Бовтів", "student2@lms.ua", "S002");
        System.out.println(student2.get_profile());
        System.out.println();
        student2.pay_course(java_course);
        System.out.println();
        
        // Крок 4: Студенти подають роботи
        System.out.println("=== КРОК 4: Студенти подають роботи ===\n");
        System.out.println("--- Студент 1 подає роботи ---");
        student1.submit_exercise(exercise1, "/uploads/student1/helloworld.java");
        System.out.println();
        
        System.out.println("--- Студент 2 подає роботи ---");
        student2.submit_exercise(exercise1, "/uploads/student2/helloworld.java");
        System.out.println();
        
        // Крок 5: Викладач перевіряє роботи
        System.out.println("=== КРОК 5: Викладач перевіряє роботи ===\n");
        System.out.println("--- Перевірка роботи студента 1 ---");
        double grade1 = teacher1.check_exercise(exercise1);
        teacher1.put_grade(student1, exercise1, grade1);
        System.out.println();
        
        System.out.println("--- Перевірка роботи студента 2 ---");
        double grade2 = teacher1.check_exercise(exercise1);
        teacher1.put_grade(student2, exercise1, grade2);
        System.out.println();
        
        // Крок 6: Студенти переглядають оцінки
        System.out.println("=== КРОК 6: Студенти переглядають оцінки ===\n");
        student1.show_grades();
        System.out.println();
        student2.show_grades();
        System.out.println();
        
        // Крок 7: Апеляція студента
        System.out.println("=== КРОК 7: Апеляція студента на оцінку ===\n");
        Appeal appeal = student1.file_an_appeal(exercise1, "Я думаю, що заслужив більшу оцінку");
        System.out.println();
        
        System.out.println("--- Викладач розглядає апеляцію ---");
        teacher1.add_appeal(appeal);
        System.out.println();
        appeal.set_decision("accepted", 95.0);
        System.out.println();
        
        // Крок 8: Перегляд профілів та розкладів
        System.out.println("=== КРОК 8: Перегляд профілів та розкладів ===\n");
        System.out.println("--- Розклад студента ---");
        student1.get_schedule();
        System.out.println();
        
        System.out.println("--- Перевірка дедлайнів студента ---");
        student1.deadline_check();
        System.out.println();
        
        System.out.println("--- Розклад викладача ---");
        teacher1.get_schedule();
        System.out.println();
        
        // Крок 9: Статистика системи
        System.out.println("=== КРОК 9: Статистика системи ===\n");
        System.out.println(admin.view_statistic());
        System.out.println();
        
        // Крок 10: Академічні сертифікати
        System.out.println("=== КРОК 10: Видача академічних сертифікатів ===\n");
        System.out.println(student1.get_academic_certificate());
        System.out.println();
        System.out.println(student2.get_academic_certificate());
        System.out.println();
        
        // Крок 11: Показ навчального плану
        System.out.println("=== КРОК 11: Показ навчальних планів ===\n");
        System.out.println(student1.show_curriculum());
        System.out.println(admin.show_curriculum());
        System.out.println();
        
        System.out.println("========================================");
        System.out.println("   Симуляція завершена успішно!");
        System.out.println("========================================");
    }
}
