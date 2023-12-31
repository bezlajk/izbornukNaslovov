## Building the application

Launch the Maven build on the checked out sources of this demo:

> ./mvnw package

### Live coding with Quarkus

The Maven Quarkus plugin provides a development mode that supports
live coding. To try this out:

> ./mvnw quarkus:dev

This command will leave Quarkus running in the foreground listening on port 8080.

### Data Base

Use https://github.com/bezlajk/izbornukNaslovov/blob/master/CreateTablesAndInsrt.sql script to create neccessery tables in your local **MySQL** table.
It also adds some insewrts in tables.
