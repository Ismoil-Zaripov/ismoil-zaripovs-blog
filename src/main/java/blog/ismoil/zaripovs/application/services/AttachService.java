package blog.ismoil.zaripovs.application.services;

import blog.ismoil.zaripovs.domain.models.response.AttachResponse;
import blog.ismoil.zaripovs.domain.repositories.AttachRepository;
import blog.ismoil.zaripovs.domain.usecases.AttachUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttachService implements AttachUseCase {

    private final AttachRepository attachRepository;

    @Value("${spring.attach.upload.path}")
    private String uploadPath;

    @Override
    public void attachUpload(MultipartFile multipartFile) {
        var path = String.format("%s/%s", uploadPath, getYmD());
        var directory = new File(path);

        if (!directory.exists()) directory.mkdirs();

        try (var fileOutputStream = new FileOutputStream(directory.getPath() +"/"+ multipartFile.getOriginalFilename())) {

            fileOutputStream.write(multipartFile.getBytes());
            attachRepository.save(multipartFile, path);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private String getYmD() {
        return String.format(
                "%s/%s/%s",
                LocalDateTime.now().getYear(),
                LocalDateTime.now().getMonthValue(),
                LocalDateTime.now().getDayOfMonth()
        );
    }

    @Override
    public List<AttachResponse> attachesList() {
        return attachRepository.findAllAttaches();
    }

    @Override
    public byte[] open(String attachName) {

        try {

            var attachPath = attachRepository.findByAttacheName(attachName);
            return Files.readAllBytes(new File(attachPath).toPath());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
