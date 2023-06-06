package com.week_12;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Locale locale, Model model) {
        model.addAttribute("homemsg", "대문 페이지입니다!");

        return "home";
    }

    @PostMapping("/submit")
//    public String dummy(@ModelAttribute("formData") StudentInfo studentInfo) {
//        return "dummy";
//    }
    public String dummy(@Validated  StudentInfo studentInfo, Errors errors) {
        if(errors.hasErrors()) {
            return "home";
        }
        return "dummy";
    }

    //redirect 처리
    @GetMapping("/submit")
    public String dummyRedirect() {
        return "redirect:/";
    }
}
