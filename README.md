Groovy Bakery
========
This is a simple bakery use-case application developed with Spring Boot MVC, Groovy, and Spring's JdbcTemplate used to persist contact data to an embedded H2 database.

Currently the UI is done in Thymleaf templates and uses Bootstrap for stylizing. Eventually looking to expand to use a js framework such as Angular

Due to the fact that this app is defined in multiple .groovy files, it will be necessary to run it with Spring Boot's CLI like this:

```sh
$ spring run *.groovy
```

Detailed Setup:
---------------------
1. Choose your IDE. I like using IntelliJ (there's  free student version)
2. Pull down the code and open in your IDE
3. Get the necessary packages. I used homebrew to get mine but it's only available for macs

	```sh
	$ brew tap pivotal/tap
	$ brew install springboot
	$ brew install groovy
	```
4. Make sure your java jdk is up to date
5. Configure the project in IntelliJ:
	* Right click the top project folder. Select 'Add Framework Support...'. Check all Spring and Groovy options available.
	* File -> Project Structure. Under 'Project' configure the sdk by navigating to your java jdk home folder
	* In ContactController you might need to option/alt + enter on a @Grab statement and select the 'Grab the artifacts' option to force the jars to pull down
6. Run the project using:  

	```sh
	$ spring run *.groovy
	```
7. If successful, navigate to 'localhost:8080' in your browser
8. Contribute!
