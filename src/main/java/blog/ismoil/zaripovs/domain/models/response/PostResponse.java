package blog.ismoil.zaripovs.domain.models.response;

import java.io.Serializable;

public record PostResponse(
        Integer postId,
        String content,
        AttachResponse attach,
        CatalogResponse catalog,
        TopicResponse topic
) implements Serializable { }
