package blog.ismoil.zaripovs.infrastructure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/questions")
public class QuestionController {
    @GetMapping
    public String questionsPage(){
        return "questions/questions-page";
    }
}
