import java.util.Scanner;

public class ProductSearchSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = {"Keyboard", "Mouse", "Monitor", "USB Cable", "Headset"};
        int[] prices = {890, 490, 5200, 250, 1290};
        int[] stocks = {12, 20, 5, 30, 8};

        int choice;

        do {
            System.out.println("\n===== 商品搜尋系統 =====");
            System.out.println("1. 顯示全部商品");
            System.out.println("2. 完整名稱搜尋");
            System.out.println("3. 部分名稱搜尋");
            System.out.println("4. 顯示名稱最長的商品");
            System.out.println("5. 顯示關鍵字首次出現的位置");
            System.out.println("6. 結束");
            System.out.print("請選擇：");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    showAllProducts(names, prices, stocks);
                    break;

                case 2:
                    System.out.print("請輸入完整商品名稱：");
                    String fullName = sc.nextLine();
                    searchFullName(names, prices, stocks, fullName);
                    break;

                case 3:
                    System.out.print("請輸入部分名稱：");
                    String part = sc.nextLine();
                    searchPartName(names, prices, stocks, part);
                    break;

                case 4:
                    showLongestName(names, prices, stocks);
                    break;

                case 5:
                    System.out.print("請輸入搜尋關鍵字：");
                    String key = sc.nextLine();
                    showFirstPosition(names, key);
                    break;

                case 6:
                    System.out.println("程式結束！");
                    break;

                default:
                    System.out.println("請輸入1~6！");
            }

        } while (choice != 6);

        sc.close();
    }

    public static void showAllProducts(String[] names, int[] prices, int[] stocks) {
        System.out.println("\n商品名稱\t價格\t庫存");

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + "\t" + prices[i] + "\t" + stocks[i]);
        }
    }

    public static void searchFullName(String[] names, int[] prices, int[] stocks, String target) {
        boolean found = false;
        target = target.trim();

        for (int i = 0; i < names.length; i++) {
            if (names[i].trim().equalsIgnoreCase(target)) {
                System.out.println("商品：" + names[i]);
                System.out.println("價格：" + prices[i]);
                System.out.println("庫存：" + stocks[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("查無商品！");
        }
    }

    public static void searchPartName(String[] names, int[] prices, int[] stocks, String key) {
        boolean found = false;
        key = key.toLowerCase().trim();

        for (int i = 0; i < names.length; i++) {
            if (names[i].toLowerCase().contains(key)) {
                System.out.println(names[i] + " 價格：" + prices[i] + " 庫存：" + stocks[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("查無商品！");
        }
    }

    public static void showLongestName(String[] names, int[] prices, int[] stocks) {
        int index = 0;

        for (int i = 1; i < names.length; i++) {
            if (names[i].length() > names[index].length()) {
                index = i;
            }
        }

        System.out.println("名稱最長商品：" + names[index]);
        System.out.println("價格：" + prices[index]);
        System.out.println("庫存：" + stocks[index]);
    }

    public static void showFirstPosition(String[] names, String key) {
        key = key.toLowerCase();

        for (String name : names) {
            int pos = name.toLowerCase().indexOf(key);

            if (pos != -1) {
                System.out.println(name + " -> 首次出現位置：" + pos);
            } else {
                System.out.println(name + " -> 未找到");
            }
        }
    }
}

