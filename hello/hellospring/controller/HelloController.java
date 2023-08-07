package hello.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // Get 방식으로 hello라는 url이 들어오면 이 메소드를 호출
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello"; // resources/templates/hello.html을 찾아서 렌더링
    }

    @GetMapping("hello-man")
    public String helloMan(Model model) {
        model.addAttribute("word", "반가워요");
        return "hello-man";
    }


    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name); // name이라는 이름으로 name을 넘겨줌
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // http의 body부에 이 데이터를 직접 넣어주겠다는 의미
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name; // "hello spring"이라는 문자열을 그대로 내려줌
    }

   @GetMapping("hello-api")
    @ResponseBody // 객체를 반환하고, 객체가 json으로 변환되어 반환됨
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello(); // Hello 객체를 생성
        hello.setName(name); // name을 넣어줌
        return hello; // json 형태로 내려줌

   }

    @GetMapping("bin2")
    @ResponseBody
    public bin2 bin23(@RequestParam("name") String name,
                      @RequestParam("age") int age,
                      @RequestParam("money") int money) {
        bin2 bin = new bin2();
        bin.setName(name);
        bin.setAge(age);
        bin.setMoney(money);
        return bin;
    }
   static class bin2{

       private String name;
        private int age;
        private int money;
       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }

       public int getAge() {
           return age;
       }

       public void setAge(int age) {
           this.age = age;
       }

       public int getMoney() {
           return money;
       }

       public void setMoney(int money) {
           this.money = money;
       }


   }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}