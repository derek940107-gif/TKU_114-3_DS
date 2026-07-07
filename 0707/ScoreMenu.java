import java.util.Scanner;

public class ScoreMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入姓名：");
        String name = scanner.next();

        System.out.print("請輸入Java成績：");
        double javaScore = scanner.nextDouble();

        System.out.print("請輸入英文成績：");
        double englishScore = scanner.nextDouble();

        System.out.print("請輸入數學成績：");
        double mathScore = scanner.nextDouble();

        double average = (javaScore + englishScore + mathScore) / 3.0;

        String status = "";
        if (average >= 60) {
            status = "及格";
        } else {
            status = "不及格";
        }

        String grade = "";
        if (average >= 90) {
            grade = "A";
        } else if (average >= 80) {
            grade = "B";
        } else if (average >= 70) {
            grade = "C";
        } else if (average >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        int choice = -1;
        while (choice != 0) {
            System.out.println("\n--- 選單 ---");
            System.out.println("1 : 顯示平均分數");
            System.out.println("2 : 顯示及格狀態");
            System.out.println("3 : 顯示等第");
            System.out.println("0 : 離開");
            System.out.print("請選擇操作項目：");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(name + " 的平均分數為：" + average);
                    break;
                case 2:
                    System.out.println(name + " 的及格狀態為：" + status);
                    break;
                case 3:
                    System.out.println(name + " 的等第為：" + grade);
                    break;
                case 0:
                    System.out.println("系統已關閉，謝謝使用！");
                    break;
                default:
                    System.out.println("無效的選項，請重新輸入！");
                    break;
            }
        }

        scanner.close();
    }
}