package blog.ismoil.zaripovs.domain.models.request;

public record PostRequest(
    String content,
    Integer attachId,
    Integer catalogId,
    Integer topicId
) { }
