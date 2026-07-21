import java.util.ArrayList;
import java.util.Scanner;

public class EquipmentManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Equipment> list = new ArrayList<>();

        int choice = -1;

        do {
            System.out.println("\n===== 設備管理系統 =====");
            System.out.println("1. 新增設備");
            System.out.println("2. 依代碼搜尋");
            System.out.println("3. 借出設備");
            System.out.println("4. 歸還設備");
            System.out.println("5. 找第一個可借設備");
            System.out.println("6. 顯示全部");
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
                    addEquipment(sc, list);
                    break;
                case 2:
                    searchEquipment(sc, list);
                    break;
                case 3:
                    borrowEquipment(sc, list);
                    break;
                case 4:
                    returnEquipment(sc, list);
                    break;
                case 5:
                    firstAvailable(list);
                    break;
                case 6:
                    showAll(list);
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

    public static void addEquipment(Scanner sc, ArrayList<Equipment> list) {

        System.out.print("設備代碼：");
        String code = sc.nextLine();

        for (Equipment e : list) {
            if (e.getCode().equalsIgnoreCase(code)) {
                System.out.println("代碼不可重複！");
                return;
            }
        }

        System.out.print("設備名稱：");
        String name = sc.nextLine();

        list.add(new Equipment(code, name));
        System.out.println("新增成功！");
    }

    public static void searchEquipment(Scanner sc, ArrayList<Equipment> list) {

        System.out.print("輸入代碼：");
        String code = sc.nextLine();

        for (Equipment e : list) {
            if (e.getCode().equalsIgnoreCase(code)) {
                System.out.println(e);
                return;
            }
        }

        System.out.println("找不到設備！");
    }

    public static void borrowEquipment(Scanner sc, ArrayList<Equipment> list) {

        System.out.print("輸入代碼：");
        String code = sc.nextLine();

        for (Equipment e : list) {
            if (e.getCode().equalsIgnoreCase(code)) {

                if (e.isAvailable()) {
                    e.borrow();
                    System.out.println("借出成功！");
                } else {
                    System.out.println("設備已借出！");
                }

                return;
            }
        }

        System.out.println("找不到設備！");
    }

    public static void returnEquipment(Scanner sc, ArrayList<Equipment> list) {

        System.out.print("輸入代碼：");
        String code = sc.nextLine();

        for (Equipment e : list) {
            if (e.getCode().equalsIgnoreCase(code)) {

                if (!e.isAvailable()) {
                    e.giveBack();
                    System.out.println("歸還成功！");
                } else {
                    System.out.println("設備本來就是可借用！");
                }

                return;
            }
        }

        System.out.println("找不到設備！");
    }

    public static void firstAvailable(ArrayList<Equipment> list) {

        for (Equipment e : list) {
            if (e.isAvailable()) {
                System.out.println("第一個可借設備：");
                System.out.println(e);
                return;
            }
        }

        System.out.println("目前沒有可借設備！");
    }

    public static void showAll(ArrayList<Equipment> list) {

        if (list.size() == 0) {
            System.out.println("沒有任何設備！");
            return;
        }

        for (Equipment e : list) {
            System.out.println(e);
        }
    }
}