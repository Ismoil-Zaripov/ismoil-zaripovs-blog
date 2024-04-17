package blog.ismoil.zaripovs.domain.repositories;

import blog.ismoil.zaripovs.domain.models.response.AttachResponse;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AttachRepository {
    void save(MultipartFile multipartFile, String path);
    List<AttachResponse> findAllAttaches();
    String findByAttacheName(String attachName);
}
