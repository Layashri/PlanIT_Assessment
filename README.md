This has been designed using Serenity BDD with POM. 

Please use the below Maven command to execute the Test scripts

To execute all test cases:

      mvn clean verify
			
To execute specific test cases using tags :

			mvn clean verify -Dcucumber.filter.tags="@Regression" -Denvironment=sit
			
Reports can be found in Target folder after execution.
