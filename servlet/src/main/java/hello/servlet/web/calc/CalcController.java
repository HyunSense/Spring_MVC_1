package hello.servlet.web.calc;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calc")
public class CalcController {


    @GetMapping("/form")
    public String calcForm() {

        return "calc-form";
    }

}
