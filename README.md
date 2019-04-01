# Validity-Home-Exercise

## The Exercise
Write a web application that parses the attached normal.csv file using Java (use Spring MVC & Spring Boot if you have experience in those) and identify possible duplicate records in the data-set.
Leverage existing implementations of the Metaphone and Levenshtein distance (no need to reinvent the wheel). We’re looking to find not just exact duplicates but also records that are likely to be a duplicate entry with different spelling, missing data, small differences, etc.


## Rules:
*	Use any resource you have available to you - but remember that we’re going to ask you questions about your code, so be prepared to defend any structure/algorithm, design/technical choices you make.
*	Ignore the odd dataset, it’s nonsensical and auto-generated. For example, email addresses do not match the Company Name.


### Getting Started

The repository has a generic Spring boot MVC application that takes .csv file as an input, parses it and displays Duplicate and non-duplicate rows found within the file. 

* Uses Levenshtein Distance as the first filter to get matching rows
* Uses Double Metaphone to finally filter out the result into multiple set of duplicates and a single set of non duplicate values

### Assumtions Made

Some assumtions that were made on the business logic are:

* No column in the input csv is given preference over the other
* For Levenshtein distance, two fields should have less than 60% changes to be considered as match (this is tranlated to 0.4 * length of each column value)
* Atleast 60% of the total number of columns should be matched with the above treshold for the row to be considered as a match (this is tranlated to 0.6 * number of columns)
* Metaphone uses only string values to be matched, for this characters other than string are discarded and empty fields are considered as not matched
* The application is generic and should work with any well formed csv with any given header and values


## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven](https://maven.apache.org)


## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.validity.duplicates.MainApp` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

To change the treshold values --field.treshold=0.4 --column.treshold=0.6 can be used with executing the jar files as command line parameters

### Design & Considerations
* Csv is converted to a List of hashmaps to represnt the csv rows with column header and values.
* To maintain Code reusability nothing is harcoded including the header values, tresholds, output table, etc...



## Thank you for your consideration and time in reviewing this application. 



