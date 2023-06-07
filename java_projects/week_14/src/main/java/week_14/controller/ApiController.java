package week_14.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import week_14.model.Member;
import week_14.model.ResponseInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {
    @Autowired
    MessageSource messageSource;

    private List<Member> memberList;

    public ApiController() {
        memberList = new ArrayList<Member>();
        memberList.add(new Member(1, "jack", "test@email.com", "password", "서울시 용산구", "010-1234-1234", 24));
    }

    @GetMapping("/api/members")
    public List<Member> members() {
        //Jackson 모듈이 알아서 객체를 JSON으로 변환해 응답해 줌
        return memberList;
    }

    @PostMapping("/api/member")
    public ResponseEntity<ResponseInfo> addMember(@RequestBody @Validated Member member, HttpServletResponse response) throws IOException {
        try { // 이름이나 아이디가 중복되면 409 CONFLICT 응답 전송 for(Member item: memberList)
            for(Member item: memberList){
                if(member.getId() == item.getId() ||
                        member.getName().equals(item.getName())){
                    return ResponseEntity.status(HttpStatus.CONFLICT)
                            .body(new ResponseInfo(HttpStatus.CONFLICT.value(),
                                    messageSource.getMessage("Conflicted", null, null)));
                }
            }
            memberList.add(member);     // 올바른 요청에는 멤버 정보 추가하고 201 CREATED 응답 전송
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ResponseInfo(HttpStatus.CREATED.value(),
                            messageSource.getMessage("Created", null, null)));
        } catch(Exception e) {
            // 기타 예외상황 발생시에는 400 BAD REQUEST 응답 전송
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseInfo(HttpStatus.BAD_REQUEST.value(),
                            messageSource.getMessage("BadRequest", null, null)));
        }

    }

}
