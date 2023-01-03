import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Работа с БД
 */
class Infrastructure {
    /*
     * Infrastructure - запуск создания БД
     */
    public Infrastructure() {
        init();
    }

    Db db;

    /*
     * Db - готовая БД
     */
    public Db getDb() {
        return db;
    }

    /*
     * getAllInfo - сбор всех данных БД
     */
    public String getAllInfo(int idStaff) {
        Staff staff = db.staff.get(idStaff - 1);

        return String.format("%s, %s, %s, %s, %s, %s",
                staff.id,
                staff.firstName,
                staff.lastName,
                staff.telephone,
                staff.adress,
                staff.experience);

    }

    /*
     * allStaff - вывод всех данных в консоль
     */
    public void allStaff() {
        System.out.println("Данные всех учеников: ");
        for (int i = 1; i <= db.staff.size(); i++) {
            System.out.println(getAllInfo(i));
        }
    }

    /*
     * search - поиск в БД
     */
    public void search(String word) {
        ArrayList<String> searchResult = new ArrayList<>();
        for (int i = 1; i <= db.staff.size(); i++) {
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
            for (int i = 1; i <= db.staff.size(); i++) {
                writer.append(getAllInfo(i) + "\n");
            }
            writer.close();
        }

    }

    /*
     * init - наполнение БД
     */
    Db init() {
        db = new Db();
        Staff staff1 = new Staff(1, "Иван", "Иванов", "56738", "Москва", "06.12.2020");
        Staff staff2 = new Staff(2, "Михаил", "Матвеенко", "75794", "Москва", "10.09.2017");
        Staff staff3 = new Staff(3, "Алексей", "Петров", "95739", "Москва", "10.03.2020");
        Staff staff4 = new Staff(4, "Анна", "Серова", "56734", "Москва", "01.10.2015");
        Staff staff5 = new Staff(5, "Ольга", "Романова", "87650", "Москва", "08.11.2018");

        db.staff.add(staff1);
        db.staff.add(staff2);
        db.staff.add(staff3);
        db.staff.add(staff4);
        db.staff.add(staff5);

        return db;
    }
}

/*
 * Создание БД
 */
class Db {
    ArrayList<Staff> staff = new ArrayList<>();

}

/*
 * Создание модели БД
 */
class Staff {
    int id;
    String firstName;
    String lastName;
    String telephone;
    String adress;
    String experience;

    public Staff(int id, String firstName, String lastName, String telephone, String addres, String experience) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.adress = addres;
        this.experience = experience;
    }
}