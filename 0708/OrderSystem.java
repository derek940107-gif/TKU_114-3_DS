import java.util.Scanner;

public class OrderSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int option = -1;
        int totalAmount = 0;
        int totalQuantity = 0;

        while (option != 0) {
            System.out.println("=== 商品選單 ===");
            System.out.println("1. 紅茶 (30元)");
            System.out.println("2. 綠茶 (35元)");
            System.out.println("3. 咖啡 (50元)");
            System.out.println("0. 查看結帳");
            System.out.print("請輸入商品選項：");
            option = sc.nextInt();

            if (option == 1 || option == 2 || option == 3) {
                System.out.print("請輸入數量：");
                int quantity = sc.nextInt();

                while (quantity <= 0) {
                    System.out.print("數量不合法，請重新輸入：");
                    quantity = sc.nextInt();
                }

                int price = 0;
                switch (option) {
                    case 1:
                        price = 30;
                        break;
                    case 2:
                        price = 35;
                        break;
                    case 3:
                        price = 50;
                        break;
                }

                int subtotal = price * quantity;
                totalAmount += subtotal;
                totalQuantity += quantity;

                System.out.println("本次小計：" + subtotal + " 元");
                System.out.println();
            } else if (option != 0) {
                System.out.println("未知選項，請重新選擇。");
                System.out.println();
            }
        }

        System.out.println("\n=== 結帳明細 ===");
        System.out.println("總數量：" + totalQuantity);
        System.out.println("總金額：" + totalAmount + " 元");

        sc.close();
    }
}