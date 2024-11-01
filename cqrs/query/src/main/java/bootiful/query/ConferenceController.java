package bootiful.query;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/conference")
public class ConferenceController {

  QueryGateway queries;

  ConferenceController(QueryGateway queries) {
    this.queries = queries;
  }


  @GetMapping
  CompletableFuture<List<Conference>> query() {
    return this.queries
        .query("allConferences", null,
            ResponseTypes.multipleInstancesOf(Conference.class));

  }

}
