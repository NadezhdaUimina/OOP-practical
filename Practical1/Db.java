import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Работа с БД
 */
class Infrastructure {
    /**
     * 
     */
    public Infrastructure() {
        init();
    }

    Db db;

    /**
     * Db - готовая БД
     */
    public Db getDb() {
        return db;
    }

    /**
     * getAllInfo - сбор всех данных БД
     * 
     * @param idStudent id ученика
     * @return строка данных в формате
     */
    public String getAllInfo(int idStudent) {
        Student student = db.student.get(idStudent - 1);

        return String.format("%s, %s, %s, %s, %s, %s",
                student.id,
                student.firstName,
                student.lastName,
                student.telephone,
                student.dateBirth,
                db.group.get(student.group-1).group);

    }

    /**
     * allStudent - вывод всех данных в консоль
     */
    public void allStudent() {
        System.out.println("Данные всех учеников: ");
        for (int i = 1; i <= db.student.size(); i++) {
            System.out.println(getAllInfo(i));
        }
    }

    /**
     * search - поиск в БД
     * 
     * @param word данные от пользователя для поиска
     */
    public void search(String word) {
        ArrayList<String> searchResult = new ArrayList<>();
        for (int i = 1; i <= db.student.size(); i++) {
            String res = getAllInfo(i);
            boolean check = res.toLowerCase().contains(word.toLowerCase());
            if (check == true) {
                searchResult.add(res + "\n");
                System.out.println(getAllInfo(i));
            }

        }
        if (searchResult.size() == 0) {
            System.out.println("Данные не найдены");
        }
    }

    /*
     * saveToFile - сохраняет БД в текстовом файле BD_file.txt
     */
    public void saveToFile() throws IOException {
        try (FileWriter writer = new FileWriter("BD_file.txt", false)) {
            for (int i = 1; i <= db.student.size(); i++) {
                writer.append(getAllInfo(i) + "\n");
            }
            writer.close();
        }

    }

    /**
     * init - наполнение БД
     */
    Db init() {
        db = new Db();
        Student student1 = new Student(1, "Иван", "Иванов", "56738", "06.12.2020", 1);
        Student student2 = new Student(2, "Михаил", "Матвеенко", "75794", "10.09.2017", 2);
        Student student3 = new Student(3, "Алексей", "Петров", "95739", "10.03.2020", 1);
        Student student4 = new Student(4, "Анна", "Серова", "56734", "01.10.2014", 3);
        Student student5 = new Student(5, "Ольга", "Романова", "87650", "8.11.2013", 3);

        db.student.add(student1);
        db.student.add(student2);
        db.student.add(student3);
        db.student.add(student4);
        db.student.add(student5);

        db.group.add(new Group(1, "Младшая группа"));
        db.group.add(new Group(2, "Дошкольная группа"));
        db.group.add(new Group(3, "Школьник"));

        return db;
    }
}

/**
 * Создание БД
 */
class Db {
    ArrayList<Student> student = new ArrayList<>();
    ArrayList<Group> group = new ArrayList<>();
}

/**
 * Создание модели БД
 */
class Student {
    int id;
    String firstName;
    String lastName;
    String telephone;
    String dateBirth;
    int group;

    public Student(int id, String firstName, String lastName, String telephone, String dateBirth, int group) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.dateBirth = dateBirth;
        this.group = group;
    }
}

/**
 * создание модели группы
 */
class Group {
    int id;
    String group;

    public Group(int id, String group) {
        this.id = id;
        this.group = group;
    }
}
