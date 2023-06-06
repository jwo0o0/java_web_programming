package practice;

public class Owner {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner() {
        System.out.println("구단주 객체가 생성되었습니다.");
    }

    public void info() {
        System.out.println("name: " + name);
    }
}
