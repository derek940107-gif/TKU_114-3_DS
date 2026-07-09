public class PricePrinter {
    public static void main(String[] args) {
        printItem("Black tea", 35);
        printItem("Green tea", 60);
    }

    public static void printItem(String itemName, int price) {
        System.out.println(itemName + ": $" + price);
    }
}