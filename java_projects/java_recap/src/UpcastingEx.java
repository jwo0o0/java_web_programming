class Person {
    String name;
    String id;

    public Person(String name) {
        this.name = name;
    }
}

class Student extends Person {
    String grade;
    String department;

    public Student(String name) {
        super(name);
    }
}

public class UpcastingEx {
    public static void main(String[] args) {
        Person p;
        Student s = new Student("김정우");
        p = s; //업캐스팅

        System.out.println(p.name);
        //System.out.println(p.grade); //컴파일 오류
        //System.out.println(p.department); //컴파일 오류
    }
}
