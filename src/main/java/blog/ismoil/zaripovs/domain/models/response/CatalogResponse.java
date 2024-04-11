package blog.ismoil.zaripovs.domain.models.response;

import java.io.Serializable;

public record CatalogResponse(
        Integer catalogId,
        String catalogName
) implements Serializable { }
