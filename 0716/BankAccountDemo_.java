public class BankAccountDemo_ {

    public static void main(String[] args) {

        BankAccount a1 = new BankAccount("A001", "王小明", 10000);
        BankAccount a2 = new BankAccount("A002", "陳小華", 5000);

        System.out.println("初始資料");
        System.out.println(a1);
        System.out.println(a2);

        System.out.println("\n存款1000");
        System.out.println(a1.deposit(1000));
        System.out.println(a1);

        System.out.println("\n提款3000");
        System.out.println(a1.withdraw(3000));
        System.out.println(a1);

        System.out.println("\n成功轉帳2000");
        System.out.println(a1.transferTo(a2, 2000));
        System.out.println(a1);
        System.out.println(a2);

        System.out.println("\n失敗轉帳20000");
        System.out.println(a1.transferTo(a2, 20000));
        System.out.println(a1);
        System.out.println(a2);
    }
}