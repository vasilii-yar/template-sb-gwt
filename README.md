# Template for spring-boot web applications with GWT/GXT ui
This template use spring-mvc as rest-api on a backend, and GWT/GXT framework as ui.
Structure of ui part based on MVP approach, that completely described in [GWT in Action](https://www.manning.com/books/gwt-in-action-second-edition) book.

## Build
This is maven project. You can download or clone it, execute (`./mvnw clean package`) in root folder, and get executeble spring-boot jar file.

## Custom gwt settings
gwt-maven-plugin configuration:
* change webappDirectory to {project directory}/target/classes/static (for gwt permutations output)
* change default deploy directory to exclude WEB-INF from result jar

*.gwt.xml configuration:
* add com.google.gwt.http.HTTP inherits (to call rest-api)
* replace ClientFactory class (for ClientFactory usage)

## Debug in intellij IDEA
To run and debug this project in Intellij IDEA follow next steps:
* Import like maven project - **File | New | Project from Existing Sources...** > choose project folder > set "Import project from external mode" > choose Maven
* Create GWT debug configuration **Run | Debug | Edit Configurations...** (GWT plugin required)
* Set "Dev mode parameters" in GWT debug configuration: `-startupUrl {home page url} -codeServerPort 9997 -port 8080 -noserver -bindAddress 0.0.0.0 -war {project folder}/target/classes/static` (replace values in {} to your own)
* Start debugging spring-boot application first **Run | Debug | {application name}**
* Then start debugging GWT application (configuration, created on step 3)
* Open link, appeared in GWT debug console (for example - http://localhost:8080/home), in browser 