package blog.ismoil.zaripovs.domain.models.response;

import java.io.Serializable;


public record AttachResponse(
        Integer fileId,
        String filename,
        String path,
        Long size
) implements Serializable { }
