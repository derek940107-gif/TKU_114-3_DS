import java.util.Scanner;

public class ArrayStatistics {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = readCount(sc);
        int[] scores = new int[count];

        inputScores(sc, scores);

        System.out.println("全部成績：");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("第" + (i + 1) + "筆：" + scores[i]);
        }

        int total = calculateTotal(scores);
        int max = findMax(scores);
        int min = findMin(scores);
        int pass = countPass(scores);
        int fail = scores.length - pass;
        double average = (double) total / scores.length;

        System.out.println("總分：" + total);
        System.out.println("平均：" + average);
        System.out.println("最高分：" + max);
        System.out.println("最低分：" + min);
        System.out.println("及格人數：" + pass);
        System.out.println("不及格人數：" + fail);

        System.out.print("請輸入要搜尋的成績：");
        int target = sc.nextInt();

        int index = findIndex(scores, target);

        if (index == -1) {
            System.out.println("找不到該成績。");
        } else {
            System.out.println("第一次出現的索引：" + index);
        }

        sc.close();
    }

    public static int readCount(Scanner sc) {
        int count;
        do {
            System.out.print("請輸入資料筆數(1~50)：");
            count = sc.nextInt();
        } while (count < 1 || count > 50);
        return count;
    }

    public static void inputScores(Scanner sc, int[] scores) {
        for (int i = 0; i < scores.length; i++) {
            do {
                System.out.print("請輸入第" + (i + 1) + "筆成績(0~100)：");
                scores[i] = sc.nextInt();
            } while (scores[i] < 0 || scores[i] > 100);
        }
    }

    public static int calculateTotal(int[] scores) {
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return total;
    }

    public static int findMax(int[] scores) {
        int max = scores[0];
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }
        return max;
    }

    public static int findMin(int[] scores) {
        int min = scores[0];
        for (int score : scores) {
            if (score < min) {
                min = score;
            }
        }
        return min;
    }

    public static int countPass(int[] scores) {
        int count = 0;
        for (int score : scores) {
            if (score >= 60) {
                count++;
            }
        }
        return count;
    }

    public static int findIndex(int[] scores, int target) {
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == target) {
                return i;
            }
        }
        return -1;
    }
}