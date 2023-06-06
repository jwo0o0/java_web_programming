package com.week_13.controller;

import com.week_13.model.InputForm;
import com.week_13.model.LoginInfo;
import com.week_13.model.StudentInfo;
import com.week_13.model.UserInfo;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
    private LoginInfo login_info;
    private UserInfo user_info;

    private void initUserInfo() {
        user_info = new UserInfo();
        user_info.setAddr("동작구 상도동");
        user_info.setBirthday(LocalDate.of(2000, 1, 1));
        user_info.setEmail("test@example.com");
    }

    public HomeController() {
        login_info = new LoginInfo();
        login_info.setUserid("test");
        login_info.setPwd("test");
        initUserInfo();
    }

    @RequestMapping(value = "/login", method= RequestMethod.GET)
    public String login(LoginInfo loginInfo, Model model, HttpSession session,
                        @CookieValue(value="REMEMBERID", required=false) Cookie rCookie) {
        //session, cookie 사용
        if (session == null || session.getAttribute("authInfo") == null) {
            if (rCookie != null) {
                loginInfo.setUserid(rCookie.getValue());
                loginInfo.setRememberid(true);
            }
        }
        return "login";
    }

    @PostMapping("/submit")
    public String loginResult(@Validated LoginInfo loginInfo, Errors errors, HttpSession session, HttpServletResponse response) {
        if (errors.hasErrors()) {
            return "login";
        }
        session.setAttribute("authInfo", loginInfo);

        Cookie rememberCookie = new Cookie("REMEMBERID", loginInfo.getUserid());
        rememberCookie.setPath("/login");
        if (loginInfo.getRememberid()) {
            rememberCookie.setMaxAge(60*60*24*30);
        } else {
            rememberCookie.setMaxAge(0);
        }
        response.addCookie(rememberCookie);

        return "login_result";
    }

    //redirect 처리
    @GetMapping("/submit")
    public String loginRedirect() {
        return "redirect:/login";
    }

    //로그아웃
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        //invalidate - 현재 세션을 무효화해 세션에 저장된 모든 데이터를 제거
        if (session != null) session.invalidate();
        return "logout";
    }

    //유저 정보
    @RequestMapping("/userinfo/{id}")
    public String userinfo(@PathVariable("id") String userid, UserInfo userInfo) {
        if(userInfo == null) userInfo = new UserInfo();
        userInfo.setAddr(user_info.getAddr());
        userInfo.setBirthday(user_info.getBirthday());
        userInfo.setEmail(user_info.getEmail());
        userInfo.setTel(user_info.getTel());
        return "userinfo";
    }

    @RequestMapping("/modifyuserinfo")
    public String modifyuserinfo(UserInfo userInfo) {
        return "modifyuserinfo";
    }

    @PostMapping("/submituserinfo")
    public String modifyUserInfoResult(@Validated UserInfo userInfo, Errors errors) {
        if(errors.hasErrors()) {
            return "modifyuserinfo";
        }
        if(userInfo != null) {
            user_info.setAddr(userInfo.getAddr());
            user_info.setBirthday(userInfo.getBirthday());
            user_info.setEmail(userInfo.getEmail());
            user_info.setTel(userInfo.getTel());
        }
        return "userinfo";
    }


    @GetMapping("/")
    public ModelAndView home(Model model) {
        List<InputForm> inputForm = Arrays.asList(new InputForm("대학", "univ"),
                new InputForm("학과", "dept"), new InputForm("이름", "name"),
                new InputForm("학번", "stdid"));

        ModelAndView mav = new ModelAndView();
        mav.addObject("homemsg", "대문 메시지");
        mav.addObject("inputForm", inputForm);
        mav.addObject("studentInfo", new StudentInfo());
        mav.setViewName("inputform");
        return mav;
    }

//    @GetMapping("/")
//    public String home(Model model) {
//        List<InputForm> inputForm =
//                Arrays.asList(new InputForm("대학", "univ"),
//                        new InputForm("학과", "dept"), new InputForm("이름", "name"), new InputForm("학번", "stdid"));
//        model.addAttribute("homemesg", "대문 페이지입니다!" ); model.addAttribute("inputForm", inputForm); model.addAttribute("studentInfo", new StudentInfo());
//        return "inputform";
//    }
}


