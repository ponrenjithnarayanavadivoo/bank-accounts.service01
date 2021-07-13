# Account Service
  REST Account service is used to create current account for existing ABC bank cutomers and retreive the account details from in-memory H2 database.
  
### Prerequisites
You need the following installed and available in your $PATH:

* Java 8
* Apache maven 3.0.4 or greater

####  Maven builds:
```
mvn clean install
```

#### Execution
```
java -jar  accounts-1.0.0.jar
```

#### To check the application deployed successfully on your local machine 
http://localhost:9082/

#### To check the DB
http://localhost:9082/h2-ui/

###  Configuration

The api is centralized on GitHub public repository and the settings.xml in the root folder needs to be configured on your local machine.

