import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCartSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<CartItem> cart = new ArrayList<>();

        int choice = -1;

        do {
            System.out.println("\n===== 購物車系統 =====");
            System.out.println("1. 加入商品");
            System.out.println("2. 修改數量");
            System.out.println("3. 顯示購物車");
            System.out.println("4. 計算總金額");
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
                    addItem(sc, cart);
                    break;
                case 2:
                    updateQuantity(sc, cart);
                    break;
                case 3:
                    showCart(cart);
                    break;
                case 4:
                    calculateTotal(cart);
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

    public static void addItem(Scanner sc, ArrayList<CartItem> cart) {

        System.out.print("商品代碼：");
        String code = sc.nextLine();

        for (CartItem item : cart) {
            if (item.getCode().equalsIgnoreCase(code)) {

                System.out.print("增加數量：");
                int qty = sc.nextInt();
                sc.nextLine();

                if (qty <= 0) {
                    System.out.println("數量必須大於0！");
                    return;
                }

                item.addQuantity(qty);
                System.out.println("數量已更新！");
                return;
            }
        }

        System.out.print("商品名稱：");
        String name = sc.nextLine();

        System.out.print("單價：");
        double price = sc.nextDouble();

        System.out.print("數量：");
        int qty = sc.nextInt();
        sc.nextLine();

        if (qty <= 0) {
            System.out.println("數量必須大於0！");
            return;
        }

        cart.add(new CartItem(code, name, price, qty));
        System.out.println("新增成功！");
    }

    public static void updateQuantity(Scanner sc, ArrayList<CartItem> cart) {

        System.out.print("商品代碼：");
        String code = sc.nextLine();

        for (CartItem item : cart) {
            if (item.getCode().equalsIgnoreCase(code)) {

                System.out.print("新的數量：");
                int qty = sc.nextInt();
                sc.nextLine();

                if (qty <= 0) {
                    System.out.println("數量必須大於0！");
                    return;
                }

                item.setQuantity(qty);
                System.out.println("修改成功！");
                return;
            }
        }

        System.out.println("找不到商品！");
    }

    public static void showCart(ArrayList<CartItem> cart) {

        if (cart.size() == 0) {
            System.out.println("購物車是空的！");
            return;
        }

        for (CartItem item : cart) {
            System.out.println(item);
        }
    }

    public static void calculateTotal(ArrayList<CartItem> cart) {

        double total = 0;

        for (CartItem item : cart) {
            total += item.getTotal();
        }

        System.out.println("總金額：" + total);
    }
}