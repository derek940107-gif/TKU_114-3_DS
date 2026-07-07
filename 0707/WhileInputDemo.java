public class WhileInputDemo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入整數（輸入 0 結束）：");
        int number = scanner.nextInt();

        while (number != 0) {
            System.out.println("你輸入的是：" + number);

            System.out.print("請再輸入整數（輸入 0 結束）：");
            number = scanner.nextInt();
        }

        System.out.println("程式結束！");
        scanner.close();
    }
}