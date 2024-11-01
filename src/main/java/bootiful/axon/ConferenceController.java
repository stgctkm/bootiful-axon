package bootiful.axon;

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

  CommandGateway commands;
  QueryGateway queries;

  ConferenceController(CommandGateway commands, QueryGateway queries) {
    this.commands = commands;
    this.queries = queries;
  }

  @PostMapping
  CompletableFuture<String> write(@RequestParam String id, @RequestParam String name) {
    return this.commands.send(new CreateConferenceCommand(id, name));
  }

  @GetMapping
  CompletableFuture<List<Conference>> query() {
    return this.queries
        .query("allConferences", null,
            ResponseTypes.multipleInstancesOf(Conference.class));

  }

}
