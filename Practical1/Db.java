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
                student.adress,
                student.experience);

    }

    /**
     * allStaff - вывод всех данных в консоль
     */
    public void allStaff() {
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
        Student student1 = new Student(1, "Иван", "Иванов", "56738", "Москва", "06.12.2020");
        Student student2 = new Student(2, "Михаил", "Матвеенко", "75794", "Москва", "10.09.2017");
        Student student3 = new Student(3, "Алексей", "Петров", "95739", "Москва", "10.03.2020");
        Student student4 = new Student(4, "Анна", "Серова", "56734", "Москва", "01.10.2015");
        Student student5 = new Student(5, "Ольга", "Романова", "87650", "Москва", "08.11.2018");

        db.student.add(student1);
        db.student.add(student2);
        db.student.add(student3);
        db.student.add(student4);
        db.student.add(student5);

        return db;
    }
}

/**
 * Создание БД
 */
class Db {
    ArrayList<Student> student = new ArrayList<>();

}

/**
 * Создание модели БД
 */
class Student {
    int id;
    String firstName;
    String lastName;
    String telephone;
    String adress;
    String experience;

    public Student(int id, String firstName, String lastName, String telephone, String addres, String experience) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.adress = addres;
        this.experience = experience;
    }
}