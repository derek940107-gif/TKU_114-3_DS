import java.util.Scanner;

public class TextAnalyzer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = inputText(sc);

        System.out.println("原始字符數：" + getOriginalLength(text));
        System.out.println("有效字符數：" + getTrimLength(text));

        String[] words = getWords(text);

        System.out.println("單字數量：" + countWords(words));
        System.out.println("元音總數：" + countVowels(text));
        System.out.println("終極單字：" + getLongestWord(words));

        System.out.print("請輸入關鍵字：");
        String keyword = sc.nextLine();

        System.out.println("出現次數：" + countKeyword(words, keyword));

        sc.close();
    }

    public static String inputText(Scanner sc) {
        String text;

        while (true) {
            System.out.print("請輸入一行文字：");
            text = sc.nextLine();

            if (!text.trim().isEmpty()) {
                return text;
            }

            System.out.println("不可輸入空字串或全空白，請重新輸入！");
        }
    }

    public static int getOriginalLength(String text) {
        return text.length();
    }

    public static int getTrimLength(String text) {
        return text.trim().length();
    }

    public static String[] getWords(String text) {
        return text.trim().split("\\s+");
    }

    public static int countWords(String[] words) {
        return words.length;
    }

    public static int countVowels(String text) {
        int count = 0;
        text = text.toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i'
                    || ch == 'o' || ch == 'u') {
                count++;
            }
        }

        return count;
    }

    public static String getLongestWord(String[] words) {
        String longest = words[0];

        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > longest.length()) {
                longest = words[i];
            }
        }

        return longest;
    }

    public static int countKeyword(String[] words, String keyword) {
        int count = 0;

        for (String word : words) {
            if (word.equalsIgnoreCase(keyword)) {
                count++;
            }
        }

        return count;
    }
}