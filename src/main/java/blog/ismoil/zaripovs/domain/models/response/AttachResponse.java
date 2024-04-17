package blog.ismoil.zaripovs.domain.models.response;

import java.io.Serializable;


public record AttachResponse(
        String attachName,
        String attachUrl
) implements Serializable { }
