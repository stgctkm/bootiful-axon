package bootiful.query;

import bootiful.model.ConferenceCreatedEvent;
import java.util.List;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

@Component
public class ConferenceProjection {

  JdbcClient jdbcClient;

  ConferenceProjection(JdbcClient jdbcClient) {
    this.jdbcClient = jdbcClient;
  }

  @EventHandler
  void handler(ConferenceCreatedEvent event) {

    System.out.println("*** ConferenceProjection.handler ---> ");

    var sql = """
        INSERT INTO conference (id, name) values(?, ?)
        """;

    jdbcClient.sql(sql)
        .param(event.id())
        .param(event.name())
        .update();

  }

  @QueryHandler(queryName = "allConferences")
  List<Conference> read() {
    var sql = """
        SELECT * FROM conference
        """;

    return jdbcClient.sql(sql)
        .query((rs, i) -> new Conference(
            rs.getString("id"),
            rs.getString("name")
        ))
        .list();
  }

}
