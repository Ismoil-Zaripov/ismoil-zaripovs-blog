package blog.ismoil.zaripovs.application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/questions")
public class QuestionController {
    @GetMapping
    public String questionsPage(){
        return "pages/questions-page";
    }
}
