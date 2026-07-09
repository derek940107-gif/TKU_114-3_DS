import java.util.Scanner;

public class OrderSystemRefactor_demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int option = -1;
        int totalAmount = 0;
        int totalQuantity = 0;

        while (option != 0) {
            printMenu();
            System.out.print("請輸入商品選項：");
            option = sc.nextInt();

            if (option == 1 || option == 2 || option == 3) {
                int quantity = readValidQuantity(sc);
                int price = getPrice(option);
                int subtotal = calculateSubtotal(price, quantity);

                totalAmount += subtotal;
                totalQuantity += quantity;

                System.out.println("本次小計：" + subtotal + " 元");
                System.out.println();
            } else if (option != 0) {
                System.out.println("未知選項，請重新選擇。");
                System.out.println();
            }
        }

        printReceipt(totalQuantity, totalAmount);
        sc.close();
    }

    public static void printMenu() {
        System.out.println("=== 商品選單 ===");
        System.out.println("1. 紅茶 (30元)");
        System.out.println("2. 綠茶 (35元)");
        System.out.println("3. 咖啡 (50元)");
        System.out.println("0. 查看結帳");
    }

    public static int getPrice(int option) {
        switch (option) {
            case 1:
                return 30;
            case 2:
                return 35;
            case 3:
                return 50;
            default:
                return 0;
        }
    }

    public static int readValidQuantity(Scanner sc) {
        System.out.print("請輸入數量：");
        int quantity = sc.nextInt();

        while (quantity <= 0) {
            System.out.print("數量不合法，請重新輸入：");
            quantity = sc.nextInt();
        }
        return quantity;
    }

    public static int calculateSubtotal(int price, int quantity) {
        return price * quantity;
    }

    public static void printReceipt(int totalItems, int totalAmount) {
        System.out.println("\n=== 結帳明細 ===");
        System.out.println("總數量：" + totalItems);
        System.out.println("總金額：" + totalAmount + " 元");
    }
}