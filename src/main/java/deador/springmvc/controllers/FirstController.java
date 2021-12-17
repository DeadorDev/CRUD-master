package deador.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
        model.addAttribute("message", "Hello " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    //Controller Calculator
    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "number_1", required = false) int number_1,
                             @RequestParam(value = "number_2", required = false) int number_2,
                             @RequestParam(value = "action", required = false) String action,
                             Model model) {
        double result;
        switch (action) {
            case "multiplication":
                result = number_1 * number_2;
                break;
            case "division":
                result = number_1 / (double) number_2;
                break;
            case "subtraction":
                result = number_1 - number_2;
                break;
            case "addition":
                result = number_1 + number_2;
                break;
            default:
                result = 0;
                break;
        }
        model.addAttribute("messageFromCalculator", result);
        return "first/calculator";
    }
}
