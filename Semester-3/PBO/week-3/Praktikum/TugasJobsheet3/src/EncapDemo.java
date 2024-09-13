public class EncapDemo {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 18) {
            this.age = 18;
        } else if (age > 30) {
            this.age = 30;
        } else {
            this.age = age;
        }
    }
}
