public class RectangleDemo_ {

    public static void main(String[] args) {

        Rectangle r1 = new Rectangle(5, 8);
        Rectangle r2 = new Rectangle(6, 6);
        Rectangle r3 = new Rectangle(10, 4);

        showRectangle(r1);
        showRectangle(r2);
        showRectangle(r3);
    }

    public static void showRectangle(Rectangle r) {
        System.out.println(r);
        System.out.println("面積：" + r.calculateArea());
        System.out.println("周長：" + r.calculatePerimeter());
        System.out.println("是否為正方形：" + r.isSquare());
        System.out.println();
    }
}