package blog.ismoil.zaripovs.domain.usecases;

import blog.ismoil.zaripovs.domain.models.response.AttachResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AttachUseCase {
    void attachUpload(MultipartFile multipartFile);
    List<AttachResponse> attachesList();
    byte[] open(String attachName);
}
