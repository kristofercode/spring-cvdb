# CVDB

A REST API for creating, updating and retrieving Resumes (CVs) and a _simple_ resume browser as a client consuming the API. I created this project during two weeks as a way of training in Spring framework and building REST APIs.  

The project is using Spring Boot including Spring MVC, Spring JPA and Thymeleaf. Other libraries used are Lombok, Mapstruct, AssertJ, Mockito. Test Driven Development using AssertJ, Mockito and Springs mock classes (e.g. MockMVC). The overall test coverage is about 80% (90% for the API).

## Database
The database is currently a in-memory H2 database initialized with data at startup.
Spring JPA with entities annotation with @Entity and interfaces extending CrudRepository are used.

## Data model
The data model is (created in JDL-studio):

[Data model diagram](https://github.com/kristofercode/cvdb/blob/master/datamodel.png)

## REST API

REST endpoints are implemented in Spring's @RestControllers.Data Transfer Objects (a.k.a command objects) are used consistently instead of Domain objects at the rest-endpoints.

MapStruct is used to generate mappers for conversion between DTO and domain objects. Conversion to Domain Objects are performed in the controllers so that the Services handle only Domain Objects

Lombok @Data, @Builder annotations was used for generated getters/setters/equals/hashcode and buildres on domainobjects and DTOs.

Custom runtime exceptions annotated with suitable Http status codes are thrown for exceptional events (for example for a POST when a resource already exists)

Thrown exceptions in the API are handled a class annotated with @ControllerAdvice. It returns a custom response object with status code, message and date.

### REST end-points

GET /api/resumes gets a list of all resumes

GET /api/resumes?firstName&lastName&freeText gets a filtered list of resumes matching firstName, lastName on owning
    person and freeText on name of owner and embedded fields (i.e. assignments, educations). The filtering is made by
    a JPQL query in api.repositories.ResumeRepository. The free text phrase is search for in the nearly all resume 
    embedded entities (by a JPQL query in the ResumeRepository).

PUT /api/resumes updates resume properties and honors upate of the person id of owning person. But it does not update person properties (e.g. name, adress).

POST /api/resumes adds a resume

GET /api/resumes{id} retrieves details of a selected resume


### Resume browser

The browser consists of the following end-points (backed by Spring Conttrollers):

/resumes (searchResumes.html)
The view displays a form for entering search criterias for searching resumes. Currently, resumes can be filtered by firstName, lastName of owning person and a freeText phrase. Search criterias are sent as query parameteres in the URL and if left empty, this view displays all resumes.

/resumes/{id}( showResume.html)
The view displays details of a resume selected in the searchResumes.html view.

## Some things left to do

### REST API
Authentication/authorization (a person can create/edit their resumes, other can only view)

Add Pagination support for resumes

Add a picture property of persons.

Add Person endpoints

### Browser
Allow Add/edit resumes

Add Pagination in the search view.

Make fancier





