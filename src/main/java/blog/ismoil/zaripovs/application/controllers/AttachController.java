package blog.ismoil.zaripovs.application.controllers;

import blog.ismoil.zaripovs.domain.usecases.AttachUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class AttachController {

    private final AttachUseCase attachUseCase;

    @PostMapping("/attaches/upload")
    public String attachUpload(@RequestParam("image") MultipartFile multipartFile) {
        attachUseCase.attachUpload(multipartFile);
        return "redirect:/galleries";
    }

    @RequestMapping(
            value = "/attaches/open/{attachName}",
            method = RequestMethod.GET,
            produces = {
                    MediaType.IMAGE_JPEG_VALUE,
                    MediaType.IMAGE_PNG_VALUE
            }
    )
    @ResponseBody
    public byte[] openImage(@PathVariable String attachName) {
        return attachUseCase.open(attachName);
    }
}
