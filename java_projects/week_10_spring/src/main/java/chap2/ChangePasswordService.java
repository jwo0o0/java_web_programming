package chap2;

import model.Member;
import model.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChangePasswordService {
    //AppContext에서 빈 객체를 찾음
    //명시적으로 setMemberDAO를 호출하지 않아도 스프링이 알아서 MemberDAO 타입의 객체를 주입
    @Autowired
    private MemberDAO memberDAO;
    
    public void changePassword(String email) {
        Member member = memberDAO.selectByEmail(email);
    }
}
