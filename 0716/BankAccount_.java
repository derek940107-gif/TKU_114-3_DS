public class BankAccount_ {

    private String account;
    private String name;
    private int balance;

    public BankAccount_(String account, String name, int balance) {
        this.account = account;
        this.name = name;
        this.balance = balance;
    }

    public String getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public boolean deposit(int amount) {
        if (amount <= 0) {
            return false;
        }

        balance += amount;
        return true;
    }

    public boolean withdraw(int amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;
        return true;
    }

    public boolean transferTo(BankAccount target, int amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;
        target.deposit(amount);
        return true;
    }

    @Override
    public String toString() {
        return "帳號：" + account + " 戶名：" + name + " 餘額：" + balance;
    }
}