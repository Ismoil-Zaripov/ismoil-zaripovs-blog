package blog.ismoil.zaripovs.application.controllers;

import blog.ismoil.zaripovs.domain.usecases.AttachUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/galleries")
public class GalleryController {

    private final AttachUseCase attachUseCase;

    @GetMapping
    public String galleriesPage(Model model) {

        model.addAttribute("attaches", attachUseCase.attachesList());
        return "pages/galleries-page";
    }
}
