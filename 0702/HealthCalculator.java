import java.util.Scanner;

public class HealthCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入資料
        System.out.print("請輸入姓名：");
        String name = scanner.nextLine();

        System.out.print("請輸入年齡：");
        int age = scanner.nextInt();

        System.out.print("請輸入身高（公尺）：");
        double height = scanner.nextDouble();

        System.out.print("請輸入體重（公斤）：");
        double weight = scanner.nextDouble();

        // 計算 BMI
        double bmi = weight / (height * height);

        // 輸出結果
        System.out.println();
        System.out.println("=== 個人健康資料 ===");
        System.out.println("姓名：" + name);
        System.out.println("年齡：" + age);
        System.out.println("身高：" + height);
        System.out.println("體重：" + weight);
        System.out.println("BMI：" + bmi);

        scanner.close();
    }
}