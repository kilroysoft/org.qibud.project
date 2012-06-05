# EventSourcing in QiBud

QiBud applies the EventSourcing pattern. Martin Fowler defines EventSourcing as
follows: "Capture all changes to an application state as a sequence of events."

You can find a lenghty article on his website:
[Event Sourcing](http://martinfowler.com/eaaDev/EventSourcing.html)

As a consequence, all Bud state changes must be captured as a sequence of
events.

## EventStore & EventSource

We will use MongoDB as both an EventStore and an EventSource for consumers.
Events should be exposed through a HTTP api, in JSON and Atom formats so that
we and others can easily write Bud events consumers.

Moreover, as UseCases will often need to make several changes at a time
we must be able to capture a sequence of events in a transactional way. This
means that the model in existing Cathedral EventStore is not suitable and we
should consider either a deep refactoring, writing a new or reusing an existing
EventStore that suits our needs.

# TO READ

http://www.mail-archive.com/qi4j-dev@lists.ops4j.org/msg05917.html

http://qi4j-dev.23929.n6.nabble.com/EventSourcing-and-UoW-completion-sequence-td832.html

https://github.com/Qi4j/qi4j-sdk/blob/develop/libraries/eventsourcing/src/main/java/org/qi4j/library/eventsourcing/domain/api/UnitOfWorkDomainEventsValue.java#L27

 
