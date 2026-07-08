import java.util.Scanner;

public class OrderSystem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int option = -1;
        int totalItems = 0;
        int totalAmount = 0;

        while (option != 0) {
            System.out.println("=== Order Menu ===");
            System.out.println("1. Black tea  $30");
            System.out.println("2. Green tea  $35");
            System.out.println("3. Coffee     $50");
            System.out.println("0. Checkout");
            System.out.print("請輸入選項：");
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
                totalItems += quantity;

                System.out.println("Subtotal: " + subtotal);
                System.out.println();
            } else if (option != 0) {
                System.out.println("Unknown option");
                System.out.println();
            }
        }

        System.out.println("\n=== Receipt ===");
        System.out.println("Total items: " + totalItems);
        System.out.println("Total amount: " + totalAmount);

        sc.close();
    }
}