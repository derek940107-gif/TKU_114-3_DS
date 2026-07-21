import java.util.ArrayList;
import java.util.Scanner;

public class DynamicScoreManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> scores = new ArrayList<>();

        int score;

        while (true) {
            System.out.print("請輸入成績(-1結束)：");

            if (!sc.hasNextInt()) {
                System.out.println("輸入錯誤！");
                sc.next();
                continue;
            }

            score = sc.nextInt();

            if (score == -1) {
                break;
            }

            if (score >= 0 && score <= 100) {
                scores.add(score);
            } else {
                System.out.println("成績必須介於0到100之間！");
            }
        }

        if (scores.size() == 0) {
            System.out.println("沒有任何成績！");
        } else {
            System.out.println("成績筆數：" + scores.size());
            System.out.printf("平均：%.2f\n", getAverage(scores));
            System.out.println("最高分：" + getMax(scores));
            System.out.println("最低分：" + getMin(scores));

            System.out.println("及格名單：");
            printPass(scores);
        }

        sc.close();
    }

    public static double getAverage(ArrayList<Integer> scores) {
        int sum = 0;

        for (int i = 0; i < scores.size(); i++) {
            sum += scores.get(i);
        }

        return (double) sum / scores.size();
    }

    public static int getMax(ArrayList<Integer> scores) {
        int max = scores.get(0);

        for (int i = 1; i < scores.size(); i++) {
            if (scores.get(i) > max) {
                max = scores.get(i);
            }
        }

        return max;
    }

    public static int getMin(ArrayList<Integer> scores) {
        int min = scores.get(0);

        for (int i = 1; i < scores.size(); i++) {
            if (scores.get(i) < min) {
                min = scores.get(i);
            }
        }

        return min;
    }

    public static void printPass(ArrayList<Integer> scores) {
        boolean found = false;

        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i) >= 60) {
                System.out.println(scores.get(i));
                found = true;
            }
        }

        if (!found) {
            System.out.println("沒有及格成績");
        }
    }
}