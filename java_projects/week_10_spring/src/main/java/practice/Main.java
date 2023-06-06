package practice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import practice.PracticeConfig;
import practice.Sports;

public class Main {
    public static void main(String[] args) {
        // AnnotationConfigApplicationContext 객체 생성 시
        // 앞서 작성한 AppContext 클래스를 생성자 파라미터로 전달.
        // AnnotationConfigApplicationContext는 AppContext에 정의한 @bean 설정 정보를 읽어와
        // Geeter 객체를 생성하고 초기화함.

        //AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
        // AppContext 클래스 설정을 읽어들이면서 선언된 빈 객체를 미리 생성


        // getbean() 메서드는 AnnotationConfigApplicationContext 가 자바 설정을 읽어와 생성한 빈(bean) 객체를 검색할 때 사용됨.
        // getBean() 메서드의 첫 번째 파라미터는 @bean 애노테이션의 메서드 이름인 빈 객체의 이름이며,
        // 두 번째 파라미터는 검색할 빈 객체의 타입임.

//        Greeter g = ctx.getBean("greeter", Greeter.class); //Bean 애노테이션이 붙은 greeter라는 이름의 클래스를 찾음
//        String msg = g.greet("스프링");
//        System.out.println(msg);
//
//        ChangePasswordService change = ctx.getBean("changePasswordService", ChangePasswordService.class);
//        change.changePassword("my email");

//        ctx.close(); // 기존에 만든 모든 빈 객체가 소멸됨


        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PracticeConfig.class);

        Sports aSports = ctx.getBean(Sports.class);
        aSports.info();

        ctx.close();

    }
}

// 싱글톤 객체
// 별도 설정이 없는 경우 스프링 - 클래스 당 한개의 객체만을 생성, 이 때 빈 객체는 싱글톤 범위를 가짐
// ex.
// Greeter g1 = ctx.getBean("greeter", Greeter.class);
// Greeter g2 = ctx.getBean("greeter", Greeter.class);
// g1과 g2는 같은 객체임