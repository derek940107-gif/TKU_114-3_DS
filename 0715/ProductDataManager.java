import java.util.Scanner;

public class ProductDataManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] records = {
                "Keyboard,890,12",
                "Mouse,490,20",
                "Monitor,5200,5",
                "USB Cable,250,30",
                "Headset,1290,8"
        };

        String[] names = new String[records.length];
        int[] prices = new int[records.length];
        int[] stocks = new int[records.length];

        for (int i = 0; i < records.length; i++) {
            String[] data = records[i].split(",");
            names[i] = data[0];
            prices[i] = Integer.parseInt(data[1]);
            stocks[i] = Integer.parseInt(data[2]);
        }

        int choice;

        do {

            System.out.println("\n===== 商品資料管理 =====");
            System.out.println("1. 顯示商品");
            System.out.println("2. 完整名稱搜尋");
            System.out.println("3. 部分名稱搜尋");
            System.out.println("4. 顯示低庫存商品");
            System.out.println("5. 顯示庫存總價值");
            System.out.println("6. 新增商品資料");
            System.out.println("7. 結束");

            System.out.print("請輸入選項：");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("商品\t\t價格\t庫存");
                    for (int i = 0; i < names.length; i++) {
                        System.out.println(names[i] + "\t" + prices[i] + "\t" + stocks[i]);
                    }
                    break;

                case 2:
                    System.out.print("請輸入完整名稱：");
                    String full = sc.nextLine().trim();

                    boolean found = false;

                    for (int i = 0; i < names.length; i++) {
                        if (names[i].equalsIgnoreCase(full)) {
                            System.out.println(names[i] + " " + prices[i] + "元 庫存：" + stocks[i]);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("查無商品");
                    }

                    break;

                case 3:
                    System.out.print("請輸入部分名稱：");
                    String part = sc.nextLine().toLowerCase();

                    found = false;

                    for (int i = 0; i < names.length; i++) {
                        if (names[i].toLowerCase().contains(part)) {
                            System.out.println(names[i] + " " + prices[i] + "元 庫存：" + stocks[i]);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("查無商品");
                    }

                    break;

                case 4:
                    System.out.println("低庫存商品：");

                    for (int i = 0; i < names.length; i++) {
                        if (stocks[i] < 10) {
                            System.out.println(names[i] + " 庫存：" + stocks[i]);
                        }
                    }

                    break;

                case 5:
                    int total = 0;

                    for (int i = 0; i < names.length; i++) {
                        total += prices[i] * stocks[i];
                    }

                    System.out.println("庫存總價值：" + total + " 元");

                    break;

                case 6:
                    System.out.print("請輸入資料(格式：名稱,價格,庫存)：");
                    String input = sc.nextLine();

                    try {
                        String[] data = input.split(",");

                        if (data.length != 3) {
                            throw new Exception("欄位數量錯誤");
                        }

                        String name = data[0];
                        int price = Integer.parseInt(data[1]);
                        int stock = Integer.parseInt(data[2]);

                        System.out.println("新增成功");
                        System.out.println(name + " " + price + "元 庫存：" + stock);

                    } catch (NumberFormatException e) {
                        System.out.println("數字格式錯誤：" + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("格式錯誤：" + e.getMessage());
                    }

                    break;

                case 7:
                    System.out.println("程式結束");
                    break;

                default:
                    System.out.println("選項錯誤");
            }

        } while (choice != 7);

        sc.close();
    }
}