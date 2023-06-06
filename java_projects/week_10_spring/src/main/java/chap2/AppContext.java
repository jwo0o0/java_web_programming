package chap2;

import model.MemberDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //스프링 설정 클래스로 지정하는 애노테이션
//Bean 객체를 설정할 수 있게 됨
//스프링 - configuration 클래스를 찾아서 Bean 객체를 관리
@ComponentScan
public class AppContext {
    @Bean //해당 메서드가 생성한 객체를 스프링이 관리하도록 지정
    public Greeter greeter() {
        Greeter g = new Greeter();
        g.setFormat("%s, 안녕하세요!");
        return g;
    }

    @Bean
    public MemberDAO memberDAO() {
        return new MemberDAO();
    }

//    @Bean
//    public ChangePasswordService changePasswordService() {
//        return new ChangePasswordService();
//    }
    // ComponentScan 애노테이션을 통해 빈이 자동으로 생성됨
}
