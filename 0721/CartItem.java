public class CartItem {

    private String code;
    private String name;
    private double price;
    private int quantity;

    public CartItem(String code, String name, double price, int quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public double getTotal() {
        return price * quantity;
    }

    public String toString() {
        return code + " " + name + " 單價:" + price + " 數量:" + quantity + " 小計:" + getTotal();
    }
}