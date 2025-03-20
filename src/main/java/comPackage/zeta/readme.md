You have to design and implement a logger library that applications can use to log messages.

Requirements
Client / application make use of logger library to log messages to a destination.

Message
has content which is of type string
has a level associated with it
is direct it to a destination

Destination
This is the destination for a message (e.g. text file, database, console etc)
Destination is tied to one or more message level
One or more message level can have the same destination

Logger library
Requires configuration during destination setup
Accepts messages from client(s)
Routes messages to appropriate destination based on the level
Supports following message level in the order of priority:  ERROR, WARN, INFO, DEBUG
Message levels above a given message level should be logged
Ex: If INFO is configured as a message level  ERROR, WARN and INFO should be logged.
The configured log level can be changed at run time. The loggers should change their behaviours accordingly.

Sending messages
destination need not be mentioned while sending a message to the logger library.
A message level is tied to a destination.
You specify message content, level and timestamp while sending a message
has context menu


has context menu