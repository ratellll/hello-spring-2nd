package hello.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello") // Get 방식으로 hello라는 url이 들어오면 이 메소드를 호출
            public String hello(Model model) {
                model.addAttribute("data", "hello!!");
                return "hello"; // resources/templates/hello.html을 찾아서 렌더링
            }

    @GetMapping("hello-man")
    public String helloman(Model model) {
        model.addAttribute("word", "반가워요");
        return "hello-man";
    }
}
