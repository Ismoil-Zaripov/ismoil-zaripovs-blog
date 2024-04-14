package blog.ismoil.zaripovs.infrastructure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/galleries")
public class GalleryController {
    @GetMapping
    public String galleriesPage(){
        return "galleries/galleries-page";
    }
}
