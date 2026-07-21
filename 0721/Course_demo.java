public class Course_demo {

    private String code;
    private String name;
    private int capacity;
    private int students;

    public Course_demo(String code, String name, int capacity) {
        this.code = code;
        this.name = name;
        this.capacity = capacity;
        this.students = 0;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getStudents() {
        return students;
    }

    public boolean addStudent() {
        if (students < capacity) {
            students++;
            return true;
        }
        return false;
    }

    public boolean removeStudent() {
        if (students > 0) {
            students--;
            return true;
        }
        return false;
    }

    public boolean isFull() {
        return students == capacity;
    }

    public String toString() {
        return code + " " + name + " 容量:" + capacity + " 已選:" + students;
    }
}