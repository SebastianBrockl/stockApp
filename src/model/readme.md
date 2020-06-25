# the model package

Includes all the functionality related to application data. Still a lot of work to do.

### Model.java

Top level Model-object initializes the rest.

### HTTPSClient.java

Simple client that executes https queries.

### URLAssembler.java

Helper class that produces alphavantage-api conformant urls based on user inputs.

### QueryHandler.java

Class that contain the functionality of executing user queries using classes above.

### QueryResult.java

Interface for passing output data from model to view. To be extended for different query-types.
