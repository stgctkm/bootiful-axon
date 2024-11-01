package bootiful.axon;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class ConferenceAggregate {

  @AggregateIdentifier
  String id;

  @CommandHandler
  public ConferenceAggregate(CreateConferenceCommand conferenceCommand) {
    apply(new ConferenceCreatedEvent(conferenceCommand.id(), conferenceCommand.name()));
  }

  @EventSourcingHandler
  void handle(ConferenceCreatedEvent event) {
    this.id = event.id();
  }
}
