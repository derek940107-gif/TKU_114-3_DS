import java.util.Scanner;

public class OrderSystem_demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int option = -1;
        int totalItems = 0;
        int totalAmount = 0;

        while (option != 0) {
            printOrderMenu();
            System.out.print("請輸入選項：");
            option = sc.nextInt();

            if (option == 1 || option == 2 || option == 3) {
                System.out.print("請輸入數量：");
                int quantity = sc.nextInt();

                quantity = validateQuantity(quantity, sc);

                int price = getPrice(option);
                int subtotal = calculateSubtotal(price, quantity);
                
                totalAmount += subtotal;
                totalItems += quantity;

                System.out.println("Subtotal: " + subtotal);
                System.out.println();
            } else if (option != 0) {
                System.out.println("Unknown option");
                System.out.println();
            }
        }

        printReceipt(totalItems, totalAmount);
        sc.close();
    }

    public static void printOrderMenu() {
        System.out.println("=== Order Menu ===");
        System.out.println("1. Black tea  $30");
        System.out.println("2. Green tea  $35");
        System.out.println("3. Coffee     $50");
        System.out.println("0. Checkout");
    }

    public static int validateQuantity(int quantity, Scanner sc) {
        while (quantity <= 0) {
            System.out.print("數量不合法，請重新輸入：");
            quantity = sc.nextInt();
        }
        return quantity;
    }

    public static int getPrice(int option) {
        switch (option) {
            case 1: return 30;
            case 2: return 35;
            case 3: return 50;
            default: return 0;
        }
    }

    public static int calculateSubtotal(int price, int quantity) {
        return price * quantity;
    }

    public static void printReceipt(int totalItems, int totalAmount) {
        System.out.println("\n=== Receipt ===");
        System.out.println("Total items: " + totalItems);
        System.out.println("Total amount: " + totalAmount);
    }
}