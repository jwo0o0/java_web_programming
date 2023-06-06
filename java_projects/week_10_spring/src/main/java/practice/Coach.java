package practice;

public class Coach {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coach() {
        System.out.println("코치 객체가 생성되었습니다.");
    }

    public void info() {
        System.out.println("name: " + name);
    }
}
