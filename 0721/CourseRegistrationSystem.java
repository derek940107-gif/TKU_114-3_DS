import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistrationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Course_demo> courses = new ArrayList<>();

        int choice = -1;

        do {
            System.out.println("\n===== 選課管理系統 =====");
            System.out.println("1. 新增課程");
            System.out.println("2. 選課");
            System.out.println("3. 退選");
            System.out.println("4. 刪除課程");
            System.out.println("5. 搜尋課程");
            System.out.println("6. 顯示統計");
            System.out.println("7. 顯示全部");
            System.out.println("0. 離開");
            System.out.print("請選擇：");

            if (!sc.hasNextInt()) {
                System.out.println("輸入錯誤！");
                sc.next();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addCourse(sc, courses);
                    break;
                case 2:
                    registerCourse(sc, courses);
                    break;
                case 3:
                    dropCourse(sc, courses);
                    break;
                case 4:
                    deleteCourse(sc, courses);
                    break;
                case 5:
                    searchCourse(sc, courses);
                    break;
                case 6:
                    showStatistics(courses);
                    break;
                case 7:
                    showAll(courses);
                    break;
                case 0:
                    System.out.println("程式結束");
                    break;
                default:
                    System.out.println("請重新輸入！");
            }

        } while (choice != 0);

        sc.close();
    }

    public static void addCourse(Scanner sc, ArrayList<Course_demo> courses) {

        System.out.print("課程代碼：");
        String code = sc.nextLine();

        for (Course_demo c : courses) {
            if (c.getCode().equalsIgnoreCase(code)) {
                System.out.println("代碼不可重複！");
                return;
            }
        }

        System.out.print("課程名稱：");
        String name = sc.nextLine();

        System.out.print("課程容量：");
        int capacity = sc.nextInt();
        sc.nextLine();

        courses.add(new Course_demo(code, name, capacity));
        System.out.println("新增成功！");
    }

    public static void registerCourse(Scanner sc, ArrayList<Course_demo> courses) {

        System.out.print("輸入課程代碼：");
        String code = sc.nextLine();

        for (Course_demo c : courses) {
            if (c.getCode().equalsIgnoreCase(code)) {

                if (c.addStudent()) {
                    System.out.println("選課成功！");
                } else {
                    System.out.println("課程已額滿！");
                }

                return;
            }
        }

        System.out.println("找不到課程！");
    }

    public static void dropCourse(Scanner sc, ArrayList<Course_demo> courses) {

        System.out.print("輸入課程代碼：");
        String code = sc.nextLine();

        for (Course_demo c : courses) {
            if (c.getCode().equalsIgnoreCase(code)) {

                if (c.removeStudent()) {
                    System.out.println("退選成功！");
                } else {
                    System.out.println("目前沒有人選課！");
                }

                return;
            }
        }

        System.out.println("找不到課程！");
    }

    public static void deleteCourse(Scanner sc, ArrayList<Course_demo> courses) {

        System.out.print("輸入課程代碼：");
        String code = sc.nextLine();

        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCode().equalsIgnoreCase(code)) {
                courses.remove(i);
                System.out.println("刪除成功！");
                return;
            }
        }

        System.out.println("找不到課程！");
    }

    public static void searchCourse(Scanner sc, ArrayList<Course_demo> courses) {

        System.out.print("輸入課程代碼：");
        String code = sc.nextLine();

        for (Course_demo c : courses) {
            if (c.getCode().equalsIgnoreCase(code)) {
                System.out.println(c);
                return;
            }
        }

        System.out.println("找不到課程！");
    }

    public static void showStatistics(ArrayList<Course_demo> courses) {

        int totalStudents = 0;

        System.out.println("額滿課程：");

        for (Course_demo c : courses) {
            totalStudents += c.getStudents();

            if (c.isFull()) {
                System.out.println(c);
            }
        }

        System.out.println("總課程數：" + courses.size());
        System.out.println("總選課人次：" + totalStudents);
    }

    public static void showAll(ArrayList<Course_demo> courses) {

        if (courses.size() == 0) {
            System.out.println("沒有課程！");
            return;
        }

        for (Course_demo c : courses) {
            System.out.println(c);
        }
    }
}