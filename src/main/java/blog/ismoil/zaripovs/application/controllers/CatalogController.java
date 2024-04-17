package blog.ismoil.zaripovs.application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/catalogs")
public class CatalogController {
    @GetMapping
    public String catalogsPage(){
        return "pages/catalogs-page";
    }
}
