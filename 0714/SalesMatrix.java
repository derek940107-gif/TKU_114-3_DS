import java.util.Scanner;

public class SalesMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] sales = new int[3][4];

        inputSales(sc, sales);
        displaySales(sales);
        productTotal(sales);
        areaTotal(sales);
        bestProduct(sales);

        sc.close();
    }

    public static void inputSales(Scanner sc, int[][] sales) {
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                do {
                    System.out.print("請輸入商品" + (i + 1) + "第" + (j + 1) + "分區銷售量：");
                    sales[i][j] = sc.nextInt();
                } while (sales[i][j] < 0);
            }
        }
    }

    public static void displaySales(int[][] sales) {
        System.out.println("銷售資料：");
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                System.out.print(sales[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void productTotal(int[][] sales) {
        System.out.println("各商品總銷售量：");
        for (int i = 0; i < sales.length; i++) {
            int total = 0;
            for (int j = 0; j < sales[i].length; j++) {
                total += sales[i][j];
            }
            System.out.println("商品" + (i + 1) + "：" + total);
        }
    }

    public static void areaTotal(int[][] sales) {
        System.out.println("各分區總銷售量：");
        for (int j = 0; j < sales[0].length; j++) {
            int total = 0;
            for (int i = 0; i < sales.length; i++) {
                total += sales[i][j];
            }
            System.out.println("分區" + (j + 1) + "：" + total);
        }
    }

    public static void bestProduct(int[][] sales) {
        int maxTotal = 0;
        int best = 0;

        for (int i = 0; i < sales.length; i++) {
            int total = 0;
            for (int j = 0; j < sales[i].length; j++) {
                total += sales[i][j];
            }
            if (total > maxTotal) {
                maxTotal = total;
                best = i;
            }
        }

        System.out.println("總銷售量最高的商品：商品" + (best + 1));
        System.out.println("總銷售量：" + maxTotal);
    }
}