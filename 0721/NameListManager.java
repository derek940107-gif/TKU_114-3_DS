import java.util.ArrayList;
import java.util.Scanner;

public class NameListManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();

        int choice = -1;

        do {
            System.out.println("\n===== 姓名管理系統 =====");
            System.out.println("1. 新增姓名");
            System.out.println("2. 搜尋姓名");
            System.out.println("3. 修改姓名");
            System.out.println("4. 刪除姓名");
            System.out.println("5. 顯示全部");
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
                    addName(sc, names);
                    break;
                case 2:
                    searchName(sc, names);
                    break;
                case 3:
                    updateName(sc, names);
                    break;
                case 4:
                    deleteName(sc, names);
                    break;
                case 5:
                    showAll(names);
                    break;
                case 0:
                    System.out.println("程式結束");
                    break;
                default:
                    System.out.println("請輸入正確選項！");
            }

        } while (choice != 0);

        sc.close();
    }

    public static void addName(Scanner sc, ArrayList<String> names) {
        System.out.print("請輸入姓名：");
        String name = sc.nextLine().trim();

        if (name.equals("")) {
            System.out.println("姓名不可空白！");
            return;
        }

        names.add(name);
        System.out.println("新增成功！");
    }

    public static void searchName(Scanner sc, ArrayList<String> names) {
        System.out.print("請輸入要搜尋的姓名：");
        String name = sc.nextLine();

        boolean found = false;

        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equalsIgnoreCase(name)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("找到姓名！");
        } else {
            System.out.println("找不到姓名！");
        }
    }

    public static void updateName(Scanner sc, ArrayList<String> names) {
        System.out.print("請輸入要修改的姓名：");
        String oldName = sc.nextLine();

        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equalsIgnoreCase(oldName)) {

                System.out.print("請輸入新姓名：");
                String newName = sc.nextLine().trim();

                if (newName.equals("")) {
                    System.out.println("姓名不可空白！");
                    return;
                }

                names.set(i, newName);
                System.out.println("修改成功！");
                return;
            }
        }

        System.out.println("找不到姓名！");
    }

    public static void deleteName(Scanner sc, ArrayList<String> names) {
        System.out.print("請輸入要刪除的姓名：");
        String name = sc.nextLine();

        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equalsIgnoreCase(name)) {
                names.remove(i);
                System.out.println("刪除成功！");
                return;
            }
        }

        System.out.println("找不到姓名！");
    }

    public static void showAll(ArrayList<String> names) {

        if (names.size() == 0) {
            System.out.println("目前沒有資料！");
            return;
        }

        System.out.println("姓名列表：");

        for (int i = 0; i < names.size(); i++) {
            System.out.println((i + 1) + ". " + names.get(i));
        }
    }
}