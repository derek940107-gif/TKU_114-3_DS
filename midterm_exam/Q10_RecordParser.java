public class Q10_RecordParser {

    public static void main(String[] args) {
        String[] records = {
                "A101|Keyboard|3|850",  
                "A102|Mouse|-1|500",
                "broken data",
                "A103|Monitor|2|4200",
                "A104||1|300"
        };

        for (String record : records) {
            System.out.println(record + " -> " + calculateRecordTotal(record));
        }

        System.out.println("合法筆數：" + countValidRecords(records));
        System.out.println("總金額：" + calculateGrandTotal(records));
    }

    public static boolean isValidRecord(String record) {

        if (record == null || record.trim().equals("")) {
            return false;
        }

        String[] data = record.split("\\|");

        if (data.length != 4) {
            return false;
        }

        if (data[0].trim().equals("") || data[1].trim().equals("")) {
            return false;
        }

        try {
            int quantity = Integer.parseInt(data[2].trim());
            int price = Integer.parseInt(data[3].trim());

            if (quantity <= 0 || price < 0) {
                return false;
            }

        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static int calculateRecordTotal(String record) {

        if (!isValidRecord(record)) {
            return -1;
        }

        String[] data = record.split("\\|");

        int quantity = Integer.parseInt(data[2].trim());
        int price = Integer.parseInt(data[3].trim());

        return quantity * price;
    }

    public static int countValidRecords(String[] records) {

        int count = 0;

        for (int i = 0; i < records.length; i++) {
            if (isValidRecord(records[i])) {
                count++;
            }
        }

        return count;
    }

    public static int calculateGrandTotal(String[] records) {

        int total = 0;

        for (int i = 0; i < records.length; i++) {
            int money = calculateRecordTotal(records[i]);

            if (money != -1) {
                total += money;
            }
        }

        return total;
    }
}