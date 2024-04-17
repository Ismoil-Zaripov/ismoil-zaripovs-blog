package blog.ismoil.zaripovs.infrastructure.jdbc.repositories;

import blog.ismoil.zaripovs.domain.models.response.AttachResponse;
import blog.ismoil.zaripovs.domain.repositories.AttachRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AttachRepositoryAdapter implements AttachRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void save(MultipartFile multipartFile, String path) {

        PreparedStatementCreator preparedStatementCreator = connection -> {
            var sql = """
                    insert into attaches(attach_name, path, size)
                    values (?, ?, ?);
                    """;

            var preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, multipartFile.getOriginalFilename());
            preparedStatement.setString(2, String.format("%s/%s", path, multipartFile.getOriginalFilename()));
            preparedStatement.setLong(3, multipartFile.getSize());

            return preparedStatement;
        };

        PreparedStatementCallback<Boolean> preparedStatementCallback = PreparedStatement::execute;

        jdbcTemplate.execute(preparedStatementCreator, preparedStatementCallback);
    }

    @Override
    public List<AttachResponse> findAllAttaches() {
        var sql = "select attaches.attach_name from attaches;";

        PreparedStatementCallback<List<AttachResponse>> preparedStatementCallback = ps -> {

            ResultSet resultSet = ps.executeQuery();
            List<AttachResponse> attachResponses = new ArrayList<>();

            while (resultSet.next()) {
                attachResponses.add(new AttachResponse(
                        resultSet.getString(1),
                        String.format("/attaches/open/%s".formatted(resultSet.getString(1)))
                ));
            }

            return attachResponses;
        };

        return jdbcTemplate.execute(sql, preparedStatementCallback);
    }

    @Override
    public String findByAttacheName(String attachName) {
        PreparedStatementCreator creator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select a.path from attaches as a where a.attach_name = ?");

            preparedStatement.setString(1, attachName);
            return preparedStatement;
        };

        PreparedStatementCallback<String> callback = statement -> {
            statement.execute();

            ResultSet resultSet = statement.getResultSet();

            if (resultSet.next()) {
                return resultSet.getString("path");
            } return null;

        };

        return jdbcTemplate.execute(creator, callback);
    }
}
