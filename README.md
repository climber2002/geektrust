# Lexicon Digital Family Tree Coding Challenge

## Description
This is a Java solution to the Family Tree Coding Challange which is created by Andy Wang (climber2002@gmail.com). It's a standard Maven project.

## Run Tests
The tests are based on JUnit5, to run all tests go to the project folder and run command (all following commands assume the current folder is the project folder),

```bash
mvn test
```

## Run the application
To run the application, firstly run following command to package a jar,

```bash
mvn package
```

It will compile the Java classes and then generate a `geektrust.jar` in sub-folder `target`. Then run following command and pass the input file path to generate output,

```bash
java -jar target/geektrust.jar <path_to_input_file>
```

In the project folder, there is a sub-folder `inputs` which provides some sample input files, so you can run following commands,

```
java -jar target/geektrust.jar inputs/input1.txt
java -jar target/geektrust.jar inputs/input2.txt
```

The application will print the output to the console.

## Assumption
The application made following assumptions,

- When the application reads an input file, if there is an invalid line, for example, the gender is not valid, or the relationship is not recognisable, it will print `INVALID_COMMAND` for the line, and continue execute following lines.
- When add a child, it assumes that the child name doesn't exist in the family tree, otherwise will print `PERSON_ALREADY_EXISTS`

## Application Design
The solution mainly has following classes,

- FamilyTree: This is the main concept which builds the Family Tree which starts from the King `Couple`, and manages all `FamilyMember`s.
- Relationship: This is an interface which can get different relationships of a `FamilyMember`, each distince `Relationship` has its own subclass, for example, `PaternalUncle`, `SisterInLaw`, etc.
- Command: This is the interface which execute a command against a `FamilyTree`, when the application reads the input file, it will convert each line into a `Command` and then execute it.
