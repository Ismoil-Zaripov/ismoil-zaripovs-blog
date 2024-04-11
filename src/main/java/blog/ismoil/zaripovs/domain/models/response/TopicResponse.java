package blog.ismoil.zaripovs.domain.models.response;

public record TopicResponse(
        Integer topicId,
        String topicName,
        CatalogResponse catalog
) { }
