public class Employee {
    private int id;
        private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Employee get(int id){
        return new Employee();
    }
}
