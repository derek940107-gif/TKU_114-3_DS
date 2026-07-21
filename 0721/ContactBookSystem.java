import java.util.ArrayList;
import java.util.Scanner;

public class ContactBookSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Contact> contacts = new ArrayList<>();

        int choice = -1;

        do {

            System.out.println("\n===== 聯絡人管理系統 =====");
            System.out.println("1. 新增聯絡人");
            System.out.println("2. 搜尋聯絡人");
            System.out.println("3. 修改電話");
            System.out.println("4. 刪除聯絡人");
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
                    addContact(sc, contacts);
                    break;
                case 2:
                    searchContact(sc, contacts);
                    break;
                case 3:
                    updatePhone(sc, contacts);
                    break;
                case 4:
                    deleteContact(sc, contacts);
                    break;
                case 5:
                    showAll(contacts);
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

    public static void addContact(Scanner sc, ArrayList<Contact> contacts) {

        System.out.print("代碼：");
        String code = sc.nextLine();    

        for (Contact c : contacts) {
            if (c.getCode().equalsIgnoreCase(code)) {
                System.out.println("代碼不可重複！");
                return;
            }
        }

        System.out.print("姓名：");
        String name = sc.nextLine().trim();

        if (name.equals("")) {
            System.out.println("姓名不可空白！");
            return;
        }

        System.out.print("電話：");
        String phone = sc.nextLine();

        System.out.print("電子郵件：");
        String email = sc.nextLine();

        contacts.add(new Contact(code, name, phone, email));
        System.out.println("新增成功！");
    }

    public static void searchContact(Scanner sc, ArrayList<Contact> contacts) {

        System.out.print("輸入代碼：");
        String code = sc.nextLine();

        for (Contact c : contacts) {
            if (c.getCode().equalsIgnoreCase(code)) {
                System.out.println(c);
                return;
            }
        }

        System.out.println("找不到聯絡人！");
    }

    public static void updatePhone(Scanner sc, ArrayList<Contact> contacts) {

        System.out.print("輸入代碼：");
        String code = sc.nextLine();

        for (Contact c : contacts) {
            if (c.getCode().equalsIgnoreCase(code)) {

                System.out.print("新電話：");
                String phone = sc.nextLine();

                c.setPhone(phone);

                System.out.println("修改成功！");
                return;
            }
        }

        System.out.println("找不到聯絡人！");
    }

    public static void deleteContact(Scanner sc, ArrayList<Contact> contacts) {

        System.out.print("輸入代碼：");
        String code = sc.nextLine();

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getCode().equalsIgnoreCase(code)) {
                contacts.remove(i);
                System.out.println("刪除成功！");
                return;
            }
        }

        System.out.println("找不到聯絡人！");
    }

    public static void showAll(ArrayList<Contact> contacts) {

        if (contacts.size() == 0) {
            System.out.println("沒有任何聯絡人！");
            return;
        }

        for (Contact c : contacts) {
            System.out.println(c);
        }
    }
}