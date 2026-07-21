public class Equipment {

    private String code;
    private String name;
    private boolean available;

    public Equipment(String code, String name) {
        this.code = code;
        this.name = name;
        this.available = true;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrow() {
        available = false;
    }

    public void giveBack() {
        available = true;
    }

    public String toString() {
        String status;

        if (available) {
            status = "可借用";
        } else {
            status = "已借出";
        }

        return code + " " + name + " " + status;
    }
}