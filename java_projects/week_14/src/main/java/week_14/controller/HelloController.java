package week_14.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/api")
    public String apiroot(Model model, @RequestParam(value="name", required = false) String name) {
        model.addAttribute("greeting", "안녕하세요, " + name);
        return "Hello, " + name;
    }

    @GetMapping("/showapi")
    public String showApi(Model model) {
        return "showapi";
    }
}
