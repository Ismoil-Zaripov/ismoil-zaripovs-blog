package blog.ismoil.zaripovs.infrastructure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/catalogs")
public class CatalogController {
    @GetMapping
    public String catalogsPage(){
        return "catalogs/catalogs-page";
    }
}
